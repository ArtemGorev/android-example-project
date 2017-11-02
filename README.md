![Ledger Leopard](https://github.com/psyhitus/android-example-project/blob/master/leopard_text.png)

# Ledger Leopard Android example project
This is an example project. It's goal is to show how to work with Android modules of ledgerleopard blockchain platform. 
This example will show next things
* How to create your own project
* How to implement splash screen for your project ( see SplashActivity.java )
* How to correctly stop executing of project to download you own configuration params ( see SplashActivity.java )
* How to include modules in project using configuration.json file and where to store it and his scructure ( see configuration.json )
* How to customize look and feel of whole projects using colors.xml and styles.xml ( see styles.xml in main project )
* How to customize look and feel of every form in existing module ( see BalanceListImpl.java )
* How to create you own module and configure it correctly ( see mucustommodule )

# To start
You need to download this project and download [project with modules](https://github.com/psyhitus/blockchain-android-modules)
When download complete please pay attention to settings.gradle. Make sure that you point exsisting pathes to modules. 
Then start reading SplashActivity.java and discover whole project. 
There are a lot of comments that you could follow to understand how it works. 
```groovy
include ':app', ':mycustommodule'

// 1. point out what modules are you going to use
include ':commons'
include ':balances'
include ':systemauthorisation'

// 2. provide path to this modules. Repository for modules can be found here https://github.com/psyhitus/blockchain-android-modules
project(':systemauthorisation').projectDir = file('../blockchain-android-modules/systemauthorisation')
project(':commons').projectDir = file('../blockchain-android-modules/commons')
project(':balances').projectDir = file('../blockchain-android-modules/balances')
```

# Links
* The repository with modules available [here](https://github.com/psyhitus/blockchain-android-modules)
* Documentation for whole android ledger leopard project available [here](http://174.138.60.151:8080/mobile/android_architecture.html)
