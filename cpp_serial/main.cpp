#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <fstream>

using namespace std;

int main() {
    int data[] = {10, 5, 13};  //Random data we want to send
    FILE *file;
    char *buffer;
    size_t result;
    long lSize;
    file = fopen("/dev/ttyUSB0", "r+");  //Opening device file
    int i = 0;
    for (i = 0; i < 3; i++) {
        const char *toPut = ("hi casey! " + to_string(i)).c_str();
        fputs(toPut, file);//also writing to file
        fprintf(file, "%d", data[i]); //Writing to the file
        fprintf(file, "%c", ','); //To separate digits
    }
    cout<<"uh";
    // obtain file size:
    fseek(file, 0, SEEK_END);
    lSize = ftell(file);
    rewind(file);

    // allocate memory to contain the whole file:
    buffer = (char *) malloc(sizeof(char) * lSize);
    if (buffer == NULL) {
        fputs("Memory error", stderr);
        cout<<"memory error "<<stderr;
        exit(2);
    }
    while(true) {
        // copy the file into the buffer:
        result = fread(buffer, lSize, 1, file);

        cout << "\nresult: " << result << "\n";
    }

    fclose(file);
    free(buffer);
    return 0;
}