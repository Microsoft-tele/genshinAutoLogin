# genshinAutoLogin
 A program to realize automatic login of Genshin
# Author
- @Microsoft-tele
- email:1784929126@qq.com
- email:liweijun0302@gmail.com

# Introduction
This programme can realize automatically login Genshin Impact when you have many account.


Every config have be setted in config.yaml


If you have no evvironment to build java project, you can download released progromme and directly use java -jar genshin.jar to start this progromme.

# Usage

## Add your account to config.yaml

![image](https://github.com/Microsoft-tele/genshinAutoLogin/assets/84846859/d51fd74c-ae3b-4da4-b045-7180f810d80b)
This is important step!!!

## Set your path at config.yaml

![image](https://github.com/Microsoft-tele/genshinAutoLogin/assets/84846859/369b92ea-5f62-492b-b52f-f11d8584c016)
- bottomIconPath: The icon of genshin at bottom windows, this picture already in directory src, you need to update this path.
- genshinIconPath: The icon of genshin at you main screen, this config item is obsolete, you don't need to revise it.
- genshinStartPath: This is also obsolete.
- pythonScript: This project has transferred python code, this python code has been provided in src, you need to update this path
- Attention: Except user account and these items, nothing needs to revise.

## Maybe

If released jar can not use, you need to revise src/Main.java.


At line 17, the path of config.yaml need to revise.


So, in theory, everyone except me can't directly call the jar.
