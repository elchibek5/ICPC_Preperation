#include <iostream>
#include <string>
using namespace std;

string checkParity(int number) {
    string checkParity(int number) {
    // It must be even AND greater than 2
    if (number > 2 && number % 2 == 0) {
        return "YES";
    } else {
        return "NO";
    }
}
}

int main() {
    int a;

    if (!(cin >> a)) return 0;

    string result = checkParity(a);
    cout << result;

    return 0;
}
