# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.9

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/danbern/Documents/robotics/2018-Code/cpp_serial

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/danbern/Documents/robotics/2018-Code/cpp_serial/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/cpp_serial.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/cpp_serial.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/cpp_serial.dir/flags.make

CMakeFiles/cpp_serial.dir/main.cpp.o: CMakeFiles/cpp_serial.dir/flags.make
CMakeFiles/cpp_serial.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/danbern/Documents/robotics/2018-Code/cpp_serial/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/cpp_serial.dir/main.cpp.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/cpp_serial.dir/main.cpp.o -c /Users/danbern/Documents/robotics/2018-Code/cpp_serial/main.cpp

CMakeFiles/cpp_serial.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/cpp_serial.dir/main.cpp.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/danbern/Documents/robotics/2018-Code/cpp_serial/main.cpp > CMakeFiles/cpp_serial.dir/main.cpp.i

CMakeFiles/cpp_serial.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/cpp_serial.dir/main.cpp.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/danbern/Documents/robotics/2018-Code/cpp_serial/main.cpp -o CMakeFiles/cpp_serial.dir/main.cpp.s

CMakeFiles/cpp_serial.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/cpp_serial.dir/main.cpp.o.requires

CMakeFiles/cpp_serial.dir/main.cpp.o.provides: CMakeFiles/cpp_serial.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/cpp_serial.dir/build.make CMakeFiles/cpp_serial.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/cpp_serial.dir/main.cpp.o.provides

CMakeFiles/cpp_serial.dir/main.cpp.o.provides.build: CMakeFiles/cpp_serial.dir/main.cpp.o


# Object files for target cpp_serial
cpp_serial_OBJECTS = \
"CMakeFiles/cpp_serial.dir/main.cpp.o"

# External object files for target cpp_serial
cpp_serial_EXTERNAL_OBJECTS =

cpp_serial: CMakeFiles/cpp_serial.dir/main.cpp.o
cpp_serial: CMakeFiles/cpp_serial.dir/build.make
cpp_serial: CMakeFiles/cpp_serial.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/danbern/Documents/robotics/2018-Code/cpp_serial/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable cpp_serial"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/cpp_serial.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/cpp_serial.dir/build: cpp_serial

.PHONY : CMakeFiles/cpp_serial.dir/build

CMakeFiles/cpp_serial.dir/requires: CMakeFiles/cpp_serial.dir/main.cpp.o.requires

.PHONY : CMakeFiles/cpp_serial.dir/requires

CMakeFiles/cpp_serial.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/cpp_serial.dir/cmake_clean.cmake
.PHONY : CMakeFiles/cpp_serial.dir/clean

CMakeFiles/cpp_serial.dir/depend:
	cd /Users/danbern/Documents/robotics/2018-Code/cpp_serial/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/danbern/Documents/robotics/2018-Code/cpp_serial /Users/danbern/Documents/robotics/2018-Code/cpp_serial /Users/danbern/Documents/robotics/2018-Code/cpp_serial/cmake-build-debug /Users/danbern/Documents/robotics/2018-Code/cpp_serial/cmake-build-debug /Users/danbern/Documents/robotics/2018-Code/cpp_serial/cmake-build-debug/CMakeFiles/cpp_serial.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/cpp_serial.dir/depend

