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
 14 (34.15%) valid and 27 (65.85%) invalid inputs.

Valid inputs as sorted:
1-) -78.00
2-) 11.00
3-) 405.00
4-) 443434.00
5-) 1609299097.00
6-) 2526772936.00
7-) 4700027789.00
8-) 5202532453.00
9-) 5870746727.00
10-) 7776118214.00
11-) 8582231353.00
12-) 8933596159.00
13-) 9555028142.00
14-) 9563529141.00
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
