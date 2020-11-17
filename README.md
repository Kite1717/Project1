## Project 1


    
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
Read 21 lines.
 9 (42.86%) valid and 12 (57.14%) invalid inputs.

Valid inputs as sorted:
1-) -23432.34
2-) -78.00
3-) -3.14
4-) 0.43
5-) 11.00
6-) 43.70
7-) 223.43
8-) 405.00
9-) 443434.00
```

### Reading log files
```
$ java Project.Main --logfile=LogFile.txt
2013-10-04  : 2 exceptions occurred.
2015-03-24  : 2 exceptions occurred.
2017-13-04  : 2 exceptions occurred.
2019-02-01  : 1 exceptions occurred.
2019-02-04  : 1 exceptions occurred.
2019-04-01  : 1 exceptions occurred.
2019-04-04  : 2 exceptions occurred.

Press Enter to see the details today...
2019-04-04 Exception, not a numeric value: A
2019-04-04 Exception, not a numeric value: SdgA
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
