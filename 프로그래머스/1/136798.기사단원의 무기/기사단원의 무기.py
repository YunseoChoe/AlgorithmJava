def get_factor_count(n):
    count = 0
    
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            count += 1 if i * i == n else 2
            
    return count

def solution(number, limit, power):
    answer = 0
    
    for i in range(1, number + 1):
        cnt = get_factor_count(i)
        
        if cnt > limit:
            answer += power
        else:
            answer += cnt
    
    return answer