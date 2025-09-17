# 방향: 상, 하, 좌, 우 (우선순위)
DIRS = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def in_range(n, r, c):
    return 0 <= r < n and 0 <= c < n
 
def get_square(n, runners, exit_pos):
    """
    한 명 이상의 참가자와 출구를 포함한 가장 작은 정사각형
    정사각형이 2개 이상이라면 우선순위: 좌상단 r좌표가 작은 것, c좌표가 작은 것이 우선됨.

    반환: 정사각형의 좌상측의 행, 열, 정사각형 한 변의 길이
    """
    exr, exc = exit_pos
    
    # 정사각형의 크기는 1부터 시작.
    for l in range(1, n + 1):
        # (i, j)이 좌상단 위치 좌표
        for i in range(0, n + 1 - l):
            for j in range(n + 1 - l):
                # 우하단 위치 좌표
                sr = i + l - 1
                sc = j + l - 1

                # 출구가 포함되어 있는지
                if not (i <= exr <= sr and j <= exc <= sc):
                    continue

                # runner가 포함되어 있는지
                for rr, rc in runners:
                    if i <= rr <= sr and j <= rc <= sc:
                        # 출구 & runner가 포함되어 있는 정사각형의 좌상단 좌표, 정사각형의 길이 반환
                        return i, j, l 

def rot90(sub_board, l):
    rotated_sub_board = [[0] * l for _ in range(l)]

    for i in range(l):
        for j in range(l):
            # 벽의 내구도 감소 (-1은 빈 칸을 나타내므로 제외)
            if sub_board[i][j] > 0:
                sub_board[i][j] -= 1

            # 시계 방향 90도 회전 공식 적용
            rotated_sub_board[j][l - 1 - i] = sub_board[i][j]

    return rotated_sub_board
            
def move(n, board, runners, exit_pos):
    """
    모든 참가자들은 동시에 움직임 -> 동시에 움직이는 것을 구현할 수 없으므로(?) for문으로..?
    빈칸: 이동 가능 | 벽: 이동 불가능 | 출구: 도달하면 즉시 종료
    현재 머물렀던 칸보다 출구까지의 최단거리가 가까워야 함. (최단거리 계산해야 함)
    움직일 수 있는 칸이 2개 이상이라면, 우선순위: 상하 (DIRS의 순서를 상, 하, 좌, 우로 하면 됨)
    한 칸에 2명 이상의 참가자가 있을 수 있음????

    반환값: (이동한 총 칸 수 증가분, 업데이트 된 runners 리스트)
    """
    exr, exc = exit_pos
    moves = 0
    updated_runners = []
    
    for r, c in runners:
        cur_dist = abs(r - exr) + abs(c - exc)
        moved = False
        
        # 상하좌우 우선순위 DIRS를 이용해 최적의 이동 위치 찾기
        for dr, dc in DIRS:
            nr, nc = r + dr, c + dc
            
            # 맵 범위 밖이거나 벽인 경우
            if not in_range(n, nr, nc) or board[nr][nc] > 0:
                continue

            next_dist = abs(nr - exr) + abs(nc - exc)
            
            # 이동할 위치가 더 가까운 경우
            if cur_dist > next_dist:
                moves += 1
                if (nr, nc) != (exr, exc):
                    updated_runners.append((nr, nc))
                moved = True
                break
        
        # 이동하지 않은 경우 (기존 자리에 머무는 경우)
        if not moved:
            updated_runners.append((r, c))

    return moves, updated_runners

# board, runners, exit_pos = rotate(board, runners, exit_pos, sr, sc, l)
def rotate(board, runners, exit_pos, sr, sc, l):
    """
    선택된 정사각형은 시계방향으로 90도 회전, 회전된 벽은 내구도 -1씩.
    반환: (new board, new runners, new exit pos)
    """
    # 회전할 board 자르기.
    sub_board = [[board[sr + i][sc + j] for j in range(l)] for i in range(l)]

    rotated_sub_board = rot90(sub_board, l)

    # 회전한 board 다시 합치기.
    for i in range(l):
        for j in range(l):
            board[sr + i][sc + j] = rotated_sub_board[i][j]


    # runners 좌표 회전 반영 (전체 참가자들의 좌표)
    updated_runners = []
    for r, c in runners:
        # sub_board 안에 있는 경우에만 좌표 회전
        if sr <= r < sr + l and sc <= c < sc + l:
            # sub_board안에서 몇 번째 인지
            rel_r = r - sr
            rel_c = c - sc
            # 시계방향 90도 회전
            new_r = sr + rel_c
            new_c = sc + (l - 1 - rel_r)
            updated_runners.append((new_r, new_c))
        # sub_board 안에 없다면 그대로
        else:
            updated_runners.append((r, c))
            
    # exit_pos 좌표 회전 반영
    er, ec = exit_pos
    if sr <= er <= sr + l and sc <= ec <= sc + l:
        rel_r = er - sr
        rel_c = ec - sc
        updated_exit_pos = (sr + rel_c, sc + (l - 1 - rel_r))
    else:
        updated_exit_pos = (er, ec)
    
    return board, updated_runners, updated_exit_pos


def main():
    n, m, k = map(int, input().split())
    runners = []
    board = []
    for _ in range(n):
        row = list(map(int, input().split()))
        board.append(row)

    for _ in range(m):
        r, c = map(int, input().split()) # 참가자 좌표
        runners.append((r - 1, c - 1))
    exr, exc = map(int, input().split()) # 출구 좌표
    exit_pos = (exr - 1, exc - 1)

    total_moves = 0

    # k번 반복
    for _ in range(k):
        # 참가자 이동
        moves, runners = move(n, board, runners, exit_pos) # 이동한 칸 수, 이동된 참가자들의 좌표
        total_moves += moves

        # K초 전에 모든 참가자들이 탈출에 성공한다면 게임 종료.
        if not runners:
            break

        # 한 명의 참가자와 출구를 포함한 가장 작은 정사각형 찾기
        sr, sc, l = get_square(n, runners, exit_pos) # 좌상단 좌표, 정사각형 길이

        # 정사각형 회전
        board, runners, exit_pos = rotate(board, runners, exit_pos, sr, sc, l)
    
    print(total_moves) # 모든 참가자들의 이동 거리 합
    print(exit_pos[0] + 1, exit_pos[1] + 1) # 출구 좌표


if __name__ == "__main__":
    main()
