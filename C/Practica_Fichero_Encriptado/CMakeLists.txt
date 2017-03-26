cmake_minimum_required(VERSION 3.6)
project(BinaryFiles)

set(CMAKE_C_STANDARD 11)

set(SOURCE_FILES src/main.c)
add_executable(BinaryFiles ${SOURCE_FILES})