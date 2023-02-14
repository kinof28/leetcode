class Solution:
    def addBinary(self, a: str, b: str) -> str:
        extra = ""
        result = ""
        a = a[::-1]
        b = b[::-1]
        minlength = min(len(a), len(b))
        for i in range(minlength):
            if (a[i] == b[i] == "1"):
                if (extra == "1"):
                    result = "1"+result
                else:
                    result = "0"+result
                    extra = "1"
            elif (a[i] == b[i] == "0"):
                if (extra == "1"):
                    result = "1"+result
                    extra = ""
                else:
                    result = "0"+result
            else:
                if (extra == "1"):
                    result = "0"+result
                else:
                    result = "1"+result
                    extra = ""
        remaining = a[minlength:]+b[minlength:]
        if (not extra == "1"):
            remaining = remaining[::-1]
            return remaining+result
        for c in remaining:
            if (extra != "1"):
                result = c+result
            else:
                if (c == "0"):
                    result = "1"+result
                    extra = ""
                else:
                    result = "0"+result

        result = extra+result
        return result
