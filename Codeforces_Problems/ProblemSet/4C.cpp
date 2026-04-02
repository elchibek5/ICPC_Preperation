#include <bits/stdc++.h>
using namespace std;

unordered_map<string, int> database;
void solve() {
    string name;
    cin >> name;

    if (database.count(name) == 0) {
        database[name] = 1;
        cout << "OK\n";
    } else {
        int count = database[name];
        string new_name = name + to_string(count);

        cout << new_name << "\n";

        database[name]++;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a;
    string ans;
    cin >> a;
    while (a--) {
        solve();
    }

    return 0;
}

