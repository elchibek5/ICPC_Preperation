#include <bits/stdc++.h>
using namespace std;

int main() {

    int n;
    cin >> n;
    vector<int> a(n);

    int odd = 0, even = 0;
    int last_odd = 0, last_even = 0;

    for (int i = 0; i < n; i++) {
        cin >> a[i];
        if (a[i] % 2 == 0) {
            even++;
            last_even = i + 1;
        }
        else {
            odd++;
            last_odd = i + 1;
        }
    }

    if (odd == 1) {
        cout <<  last_odd;
    } else {
        cout << last_even;
    }
}