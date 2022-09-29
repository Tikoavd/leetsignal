int solution(int a) {
    int number = 0;
    while(a > 0)
    {
        number = number << 1;
        number += a & 1;
        a = a >> 1;
    }
    return number;
}
