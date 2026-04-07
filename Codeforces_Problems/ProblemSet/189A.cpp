#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, a, b, c;
    cin >> n >> a >> b >> c;

    vector<int> nums(n + 1, -1);
    nums[0] = 0;

    for (int i = 0; i <= n; i++) {
        if (nums[i] >= 0) {
            if (i + a <= n) {
                nums[i + a] = max(nums[i + a], nums[i] + 1);
            }

            if (i + b <= n) {
                nums[i + b] = max(nums[i + b], nums[i] + 1);
            }

            if (i + c <= n) {
                nums[i + c] = max(nums[i + c], nums[i] + 1);
            }
        }
    }

    cout << nums[n];
}