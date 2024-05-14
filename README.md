# File Stores in AWS S3

We can store any types of file like images, pdf, ppt, word file etc in S3 bucket by using Java Spring boot code.

- Steps :
  - Create Spring boot application.
  - Add web dependency.
  - Add below aws sdk dependency
    ```
      <dependency>
  		  <groupId>com.amazonaws</groupId>
  			<artifactId>aws-java-sdk-s3</artifactId>
  			<version>1.12.720</version>
  		</dependency>
    ```
  - You can add below dependency instead of above :
    ```
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-aws</artifactId>
        <version>2.2.6.RELEASE</version>
      </dependency>

    ```
  - Create Config class & create AmazonS3 bean.
  - Create Service class.
  - Create Controller.
  - Create yaml file and add s3 bucket credentials.
