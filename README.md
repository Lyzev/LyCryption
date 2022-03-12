<h1 align="center">LyCryption</h1>

<p align="center">A simple cipher which uses bit shifting and java.util.Random.</p>

<div align="center">
    <a href="https://discord.gg/5UmsQP4MFH"><img src="https://img.shields.io/discord/610120595765723137?logo=discord" alt="Discord"/></a>
    <br><br>
    <img src="https://img.shields.io/github/last-commit/Lyzev/LyCryption" alt="GitHub last commit"/>
    <img src="https://img.shields.io/github/commit-activity/w/Lyzev/LyCryption" alt="GitHub commit activity"/>
    <br>
    <img src="https://img.shields.io/github/languages/code-size/Lyzev/LyCryption" alt="GitHub code size in bytes"/>
    <img src="https://img.shields.io/github/contributors/Lyzev/LyCryption" alt="GitHub contributors"/>
</div>

## Usage

### How to Build and Run Project
Build project: 
```bash
mvn package
```
Import ./target/LyCryption.jar file.

### Import Library
Download the newest version of the cipher on [Releases](https://github.com/Lyzev/LyCryption/releases) and import into your project.

### Example
#### Code:
```java
/**
 * This is an example on how to use LyCryption.
 */
public static void main(String[] args) {
    LyCryption cipher = new LyCryption("YOUR-KEY"); // Create an instance of LyCryption with your own key
    System.out.println("Input: YOUR-TEXT");
    String encrypted = cipher.encrypt("YOUR-TEXT"); // Encrypt your text with the method encrypt of the instance
    System.out.println("Encrypt: " + encrypted);
    String decrypted = cipher.decrypt(encrypted); // Decrypt your text with the method decrypt of the instance
    System.out.println("Decrypt: " + decrypted);
}
```
#### Output:
```
Input: YOUR-TEXT
Encrypt: 4Kyg4KegyqjKkMK0yqDgoqDgrIDgqoA=
Decrypt: YOUR-TEXT
```

## Bugs and Suggestions
Bug reports and suggestions should be made in this repo's [issue tracker](https://github.com/Lyzev/LyCryption/issues) using the templates provided. Please provide as much information as you can to best help us understand your issue and give a better chance of it being resolved.

## Important
Please note that this cipher was not developed by a professional cryptologist. Therefore, there may be a security vulnerability.
