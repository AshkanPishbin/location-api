## Maven Project check
If the IDEA does not recognize the project as a Maven project, you have to set it manually.
- Click with right mouse on **pom.xml** than choose **add as maven project**.
---

## Start Database Server
1. Open command prompt (**cmd**) and go to **C:\Entwicklung\tools\db-derby-10.15.2.0-bin\bin**
2. Write the following command: **startNetworkServer**
---

## Connect to Database
1. Click **Database** on the right side.
2. Click on **plus symbol**, then on Data Source and select the Apache Derby database.
3. In the General select the **Apache Derby Remote** as driver.
4. Fill the following fields like this:
    1. **Name:** Derby
    2. **Comment:** Hibernate
    3. **Host:** localhost
    4. **Port:** 1527
    5. **User:** location
    6. **Password:** location   
    7. **URL:** jdbc:derby://localhost:1527/location;create=true
5. **Test** the connection
---

## Check entity
1. Select an **entity** and check if the **name** of the column/table has the correct **data soruce**.
   If they are not correct, change them.
---

## Maven
1. Click **Maven** on the right side.
2. Select your maven project than click on **Lifecycle**.
3. Select **clean** and **install** from the list and **run** it.
---