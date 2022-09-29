int solution(int n, int k) {
  return ((int) Math.pow(2, k-1) ^ n) & n;
}
