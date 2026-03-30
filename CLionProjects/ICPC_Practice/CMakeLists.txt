cmake_minimum_required(VERSION 3.20)
project(ICPC_Practice)

set(CMAKE_CXX_STANDARD 20)

# 1. Find all .cpp files in the current directory and subdirectories
file(GLOB_RECURSE SOURCES RELATIVE ${CMAKE_CURRENT_SOURCE_DIR} "*.cpp")

# 2. Loop through each file and create an executable
foreach(source_file ${SOURCES})
    # Remove the .cpp extension to create a clean name for the runner
    string(REPLACE ".cpp" "" exe_name ${source_file})
    # Replace slashes with underscores (e.g., Codeforces/A.cpp -> Codeforces_A)
    string(REPLACE "/" "_" exe_name ${exe_name})

    add_executable(${exe_name} ${source_file})
endforeach()