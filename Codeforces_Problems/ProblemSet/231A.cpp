#include <bits/stdc++.h>
using namespace std;


int solve() {
    int a, b, c;
    cin >> a >> b >> c;
    return (a + b + c >= 2);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    int total_solved = 0;

    while (n--) {
        total_solved += solve();
    }

    cout << total_solved << "\n";
    return 0;
}