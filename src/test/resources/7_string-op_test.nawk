string[] arr = "1 2 3 4 5"@{
    :"Integer": {return this;}
    :!"Integer":
};

print(arr[0]);

string[] arr2 = "01abc:;"@{
    :"Integer": {return this;}
    :"Char": {return "x";}
};

print(len(arr2));
print(arr2[0]);
