import sys

str = sys.stdin.readline().rstrip()
ret = 1

for i in range(1, len(str)):
    if str[i] == ' ':
        ret += 1

if len(str) == 0:
    ret = 0

print(ret)