#include <bits/stdc++.h>
using namespace std;

int sumX = 0, sumY = 0, sumZ = 0;

void solve() {
    int x, y, z;
    cin >> x >> y >> z;

    sumX += x;
    sumY += y;
    sumZ += z;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    while (n--) {
        solve();
    }

    if (sumX == 0 && sumY == 0 && sumZ == 0) {
        cout << "YES";
    } else {
        cout << "NO";
    }

    return 0;
}