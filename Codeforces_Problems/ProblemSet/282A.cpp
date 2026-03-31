#include <bits/stdc++.h>
using namespace std;

int ans = 0;

void solve() {
    string a;
    cin >> a;

    if (a[1] == '+') {
        ans++;
    } else {
        ans--;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    while (n--) {
        solve();
    }

    cout << ans;
    return 0;
}