158. Read N Characters Given Read4 II - Call multiple times
Hard

357

858

Favorite

Share
Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters. Your method read may be called multiple times.

 

Method read4:

The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf.

The return value is the number of actual characters read.

Note that read4() has its own file pointer, much like FILE *fp in C.

Definition of read4:

    Parameter:  char[] buf
    Returns:    int

Note: buf[] is destination not source, the results from read4 will be copied to buf[]
Below is a high level example of how read4 works:

File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
char[] buf = new char[4]; // Create buffer with enough space to store characters
read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file
 

Method read:

By using the read4 method, implement the method read that reads n characters from the file and store it in the buffer array buf. Consider that you cannot manipulate the file directly.

The return value is the number of actual characters read.

Definition of read:

    Parameters: char[] buf, int n
    Returns:    int

Note: buf[] is destination not source, you will need to write the results to buf[]
 

Example 1:

File file("abc");
Solution sol;
// Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.
sol.read(buf, 1); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.
sol.read(buf, 2); // Now buf should contain "bc". We read a total of 2 characters from the file, so return 2.
sol.read(buf, 1); // We have reached the end of file, no more characters can be read. So return 0.
Example 2:

File file("abc");
Solution sol;
sol.read(buf, 4); // After calling your read method, buf should contain "abc". We read a total of 3 characters from the file, so return 3.
sol.read(buf, 1); // We have reached the end of file, no more characters can be read. So return 0.
 

Note:

Consider that you cannot manipulate the file directly, the file is only accesible for read4 but not for read.
The read function may be called multiple times.
Please remember to RESET your class variables declared in Solution, as static/class variables are persisted across multiple test cases. Please see here for more details.
You may assume the destination buffer array, buf, is guaranteed to have enough space for storing n characters.
It is guaranteed that in a given test case the same buffer buf is called by read.

紀錄讀寫位置
下一個Read進來可直接利用
比如file("abcdefg")，然后要求的是[read(1), read(2), read(2), read(1)]。
1. 调用read(1)后，此时buff为空，调用一个read4，buff中存储了“abcd”，writePos = 4，然后从buff中读出1个字符到buf，那么就是第一个字符["a"]，此时readPos = 1。
2. 调用read(2)，此时readPos = 1 < writePos = 4，所以先从buf中读取2个字符，也就是["bc"]，此时readPos = 3。
3. 然后read(2)，此时readPos = 3 < readPos = 4，所以继续从buff中读取，但是buffer中只剩下一个字符了，所以先把它读到buf中，["d"]，然后readPos == writePos了，所以readPos重置为0，继续循环。此时readPos = 0，我们调用一个read4填充buff，buff中为"efg"，然后我们可以继续读取一个字符到buf中，也就是这次最终读取的结果为["de"]。
4. 最后一次是调用read(1)，则是把buff中的1个字符复制到buf中，得到["f"]



/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    char[] sysCallbuff = new char[4];
    int innerReadPos = 0;
    int sysReadPos = 0;
    public int read(char[] buf, int n) {
        int innerIDX =0;
        while(innerIDX<n){
            if(innerReadPos==0){
                sysReadPos = read4(sysCallbuff);
            }
            while(innerIDX<n && innerReadPos<sysReadPos){
                buf[innerIDX++]=sysCallbuff[innerReadPos++];
            }
            if(innerReadPos==sysReadPos) innerReadPos=0;
            if(sysReadPos<4) break;
        }
        return innerIDX;
    }
}




#157
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    char[] buffer = new char[4];
    public int read(char[] buf, int n) {
        int cur=0;
        int pointer=0;
        while(pointer<n){
            int i = read4(buffer);
            int j=0;
            while(pointer<n&&j<i){
                buf[pointer++] = buffer[j++];
            }
            //cur+=i;
            if(i<4) break;
        }
        return pointer;
    }
}