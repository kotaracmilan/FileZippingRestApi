# FileZippingRestApi
Spring Boot Rest Api For Zipping Files

Service is not fully implemented. I implemented only FileManager and FileCopmpressionService for zip file handling.

If adding more than one archiving method, one should create class that will implement FileCompressionService interface, and initialize implemented Bean. Later inside FileManager service inject dependency toward new archiving implementation.
Further improvements could be made by creating Enum class with available archiving algorithms and HashSet with reference to those implementations.

For increased request count, increased number of threads could be defined through properties file, rective approach count be applied, which will deblock api while waiting to internal I/O process. With addition, queue creation for archiving could be implemented. Also application could be deployed inside container with increased number of instances.

All properties values are set as environmental variable, so that could be changed through environment variable. Also, increasing size. Also streaming api could be implemented that will write file on the permanent location, rather than in temp file. Different implementation of FileManager or DataStorage interfaces could be created.
Also, libraries that are handling sending files in chunks could be implemented. That way uploading of large files could be paused if necessary.

