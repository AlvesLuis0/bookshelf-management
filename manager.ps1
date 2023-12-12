param (
  [string]$COMMAND = $args[0]
)

switch ($COMMAND) {
  "install" {
    mvn package -DskipTests
  }

  "run" {
    Get-Content .env | ForEach-Object {
      $key, $value = $_ -split '=', 2
      [System.Environment]::SetEnvironmentVariable($key, $value)
    }
    java -jar target/bookshelf-management-1.0.0.jar
  }

  "clean" {
    mvn clean
  }

  default {
    Write-Host "[WARNING] Unknown command."
  }
}