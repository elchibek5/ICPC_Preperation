#include <bits/stdc++.h>
using namespace std;

void solve() {
    long long n, m, a;
    cin >> n >> m >> a;

    long long tiles_n = (n + a - 1) / a;
    long long tiles_m = (m + a - 1) / a;

    long long answer = tiles_m * tiles_n;
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    solve();
}