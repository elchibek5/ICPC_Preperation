#include <bits/stdc++.h>
using namespace std;

// 1 <= n <= 10^5 -> 100.000
// 1 <= n <= 10^12 -> 1.000.000.000.000
const int maxx = 1000001;
bool is_prime[maxx];

void build() {
    fill(is_prime, is_prime + maxx, true);
    is_prime[0] = is_prime[1] = false;

    for (int i = 2; i * i < maxx; i++) {
        if (is_prime[i]) {
            for (int j = i * i ; j < maxx ; j += i) {
                is_prime[j] = false;
            }
        }
    }
}
void solve() {
    long long n;
    cin >> n;

    long long root = round(sqrt(n));

    if (n > 1 && root * root == n && is_prime[root]) {
        cout << "YES\n";
    } else {
        cout << "NO\n";
    }

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    build();

    int a;
    cin >> a;

    while (a--) {
        solve();
    }
}