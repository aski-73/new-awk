string[] arr = "01abc:;"@{
    :"Integer": {return this;}
    :"Char": {return "x";}
};
print(len(arr));
int j = 0;
while (j < len(arr)) {
    print(arr[j]);
    j = j + 1;
}

double pi = 3.14;
double d = 15;
print(pi * d);
print("Das ist ein Text mit einer Zahl " + d);

int quad(int a) {
    return a*a;
}
print(quad(25));

int[] intArray = {1, 2, 3, 4, 5};
int[] newIntArray = intArray[i[0] % 2 == 0];
j = 0;
while (j < len(newIntArray)) {
    print(newIntArray[j]);
    j = j +1;
}

int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
j = 0;
int k = 0;
while (j < len(arr2)) {
    k = 0;
    while (k < len(arr2[j])) {
        print(arr2[j][k]);
        k = k + 1;
    }

    ++j;
}