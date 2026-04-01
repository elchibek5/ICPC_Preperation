#include <bits/stdc++.h>
using namespace std;

void solve() {
    string word;
    string result;
    cin >> word;

    for (int i = 0; i < word.size() ; i++) {
        char c = tolower(word[i]);
        if (c == 'a' || c == 'o' || c == 'y' || c == 'e' || c == 'u' || c == 'i') {
            continue;
        } else {
            result += '.';
            result += c;
        }
    }

    cout << result;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    solve();

    return 0;
}