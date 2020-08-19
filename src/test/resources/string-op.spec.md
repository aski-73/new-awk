# Specification of the "@" string operator
- Split a string in tokens defined by regex.
- If matches regex, the defined action activates
- If no action exists the matched character will be returned
- Syntax:  
```
   (StringIdentifier|StringLiteral)@{  
        :RegEx: {Action}  
    }
    Output: Array with elements that match the regex 
```
- Examples:
```
    "1 2 3 4 5 10 a b c"@{
        :Integer: {return this;}
        :!Integer: {return 0;}
    }
    Output: {1, 2, 3, 4, 5, 10, 0, 0, 0}
```
```
    "text with pointless content"@{
        :"text": 
    }
    Output: {"text"}
```
```
    "text with pointless content text text"@{
        :"text": 
    }
    Output: {"text", "text", "text"}
```