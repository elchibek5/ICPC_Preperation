#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, t;
    cin >> n >> t;
    vector<int> vector(n);

    for (int i = 0; i < n; i++) {
        cin >> vector[i];
    }

    int left = 0;
    int maxBooks = 0;
    int curr = 0;

    for (int right = 0; right < n; right++) {
        curr += vector[right];

        while (curr > t) {
            curr -= vector[left];
            left++;
        }

        maxBooks = max(maxBooks, right - left + 1);
    }

    cout << maxBooks;

}