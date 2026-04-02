#include <bits/stdc++.h>
using namespace std;

int solve() {
    string word;
    cin >> word;
    string target = "hello";
    int j = 0;

    for (int i = 0; i < word.size(); i++) {
        if (target[j] == word[i]) {
            j++;
        }

        if (j == 5) return true;
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    if (solve()) {
        cout << "YES";
    } else {
        cout << "NO";
    }

}
