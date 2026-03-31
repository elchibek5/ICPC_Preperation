cmake_minimum_required(VERSION 3.20)
project(ICPC_Practice)

set(CMAKE_CXX_STANDARD 20)

# 1. Find all .cpp files
file(GLOB_RECURSE SOURCES RELATIVE ${CMAKE_CURRENT_SOURCE_DIR} "*.cpp")

# 2. Loop through each file and create a UNIQUE executable
foreach(source_file ${SOURCES})
    # Create a clean name (e.g., Codeforces/71A.cpp -> Codeforces_71A)
    string(REPLACE ".cpp" "" exe_name ${source_file})
    string(REPLACE "/" "_" exe_name ${exe_name})

    # FIX: Only link the current source_file to its corresponding executable
    add_executable(${exe_name} ${source_file})
endforeach()