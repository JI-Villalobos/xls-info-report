# xls-info-report

Xls-info-report is a Spring Shell demo created to extract essential information about sales and commissions from xls files.

This demo is only for educational purposes, and is currently on development, and tested only on Windows Os

## Usage

This project only support java versions > 17 and use Gradle as build tool, make sure your JVM supports the latest LTS version. 

Build:
```bash
build gradle -x test
```

Run the app:
```bash
java -jar .\build\libs\report-0.0.1-SNAPSHOT.jar
```

It´s necessary set the file target on Desktop directory in order to extract the sales by shift.
```bash
extract -p file_name.xls
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

I Promise create and update tests as appropriate.... Eventually (◕‿~).

