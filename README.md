## Project 1
[![Status](https://img.shields.io/badge/Status-Completed-blue.svg)](https://github.com/DokuzEylulCsc/proje-1-muf/tree/master/Project)

- Description: [3. Dosyadaki Hakikat](https://github.com/DokuzEylulCsc/proje-1-muf/tree/master/DESCRIPTION.md)
- Using `Java and JDK 11.`

### Contributors / Students

- Mert Dede
    - GitHub: `Anaxilaus`
    - No: `2016280010`
- Uluğbey Alp
    - GitHub: `UlugbeyAlp`
    - No: `2016280002`
- Mustafa Fırat Yılmaz
    - GitHub: `Kite1717`
    - No: `2016280037`

    
**Team name: `MUF.` Stands for `M`ert, `U`luğbey and `F`ırat.**

    
## Usage

### Input file

```
$ java Project.Main --filepath=$path_of_input_file
------ or ------
$ java Project.Main
Type a valid filepath: $path_of_input_file
```

### Read log file
**Note:** Program appends logs at `./LogFile.txt`

```
$ java Project.Main --logfile=$path_of_logfile
```

## Examples
### Input Files

```
$ java Project.Main --filepath=TestCases.txt
Read 41 lines.
14 (34.14%) valid and 27 (65.85%) invalid inputs.

Valid inputs as sorted:
1) -78.0
2) 11.0
3) 405.0
4) 443434.0
5) 1.609299097E9
6) 2.526772936E9
7) 4.700027789E9
8) 5.202532453E9
9) 5.870746727E9
10) 7.776118214E9
11) 8.582231353E9
12) 8.933596159E9
13) 9.555028142E9
14) 9.563529141E9
```

### Reading log files
```
$ java Project.Main --logfile=LogFile.txt
2019-04-01 : 27 exceptions occurred.
```

## File Structure

```
├── README.md [Information about project]
├── Project
|   ├── Main.java
|   ├── Converter.java
|   ├── Sorter.java
|   ├── Logger.java
|   ├── Number.java
|   ├── Decimal.java (Number)
|   ├── Floating.java (Number)
├── .gitignore
├── DESCRIPTION.md
```
