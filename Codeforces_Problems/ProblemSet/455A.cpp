#include <bits/stdc++.h>
using namespace std;

int main() {
    int s;
    int max_val = 0;
    cin >> s;
    vector<long long> cnt(100001, 0);

    for (int i = 0; i < s; i++) {
        int val;
        cin >> val;
        cnt[val]++;
        if (val > max_val) max_val = val;
    }

    vector<long long> dp(100001, 0);

    dp[0] = 0;
    dp[1] = cnt[1] * 1;

    for (int i = 2; i <= max_val; i++) {
        dp[i] = max(dp[i - 1], dp[i - 2] + (long long)i * cnt[i]);
    }

    cout << dp[max_val];

    return 0;
}