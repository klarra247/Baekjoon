def solution(n):
    answer = 0
    
    for i in range(1, int(n // 2) + 1):
        if n % i == 0:
            answer += i

        print(answer + n)
    return answer + n