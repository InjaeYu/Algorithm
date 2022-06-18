import sys

dial = {2: ['A', 'B', 'C'], 3: ['D', 'E', 'F'], 4: ['G', 'H', 'I'], 5: ['J', 'K', 'L'],
        6: ['M', 'N', 'O'], 7: ['P', 'Q', 'R', 'S'], 8: ['T', 'U', 'V'], 9: ['W', 'X', 'Y', 'Z']}

a = sys.stdin.readline().rstrip()

num = []

for i in range(len(a)):
    for k, v in dial.items():
        if a[i] in v:
            num.append(k)
            break

for i in range(len(num)):
    num[i] += 1
    
print(sum(num))