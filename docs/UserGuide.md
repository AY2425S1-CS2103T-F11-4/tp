---
layout: page
title: User Guide
---

<link rel="stylesheet" type="text/css" href="assets/css/UserGuide.css">

**EZSTATE** is a Command Line Interface (CLI) desktop app designed specifically **real estate agents** who manage buyer and seller contacts, listings, and appointments.

<br> **You are part of the ideal target audience of EZSTATE if you meet the following characteristics**:

* `Job` : Real Estate Agent focused on managing buyer and seller relationships 
* `Typing ability` : Comfortable with typing speeds of ~80 WPM or higher 
* `Workflow Preference` : Prefers streamlined typing commands over navigating Graphic User Interface (GUI) buttons 
* `Tech Savviness` : Confident using command-based applications and prefers minimal mouse use 
* `Work Style` : Handles multiple clients and properties simultaneously and values efficiency in contact and property management
* `Environment` : Works in a fast-paced setting where quick data entry and retrival are essential

But do not worry if you do not meet every characteristic — **EZSTATE** is designed to be **intuitive and efficient for all users**.
<br> Give it a try, and head over to our Quick Start guide to get started and see how **EZSTATE** can make your contact and property management tasks faster and easier!

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick Start Guide

Welcome to **EZSTATE**! This guide will walk you through installing the app and getting started with basic commands.

### Installation Steps

1. Ensure you have Java `17` or above installed in your Computer. You can check by opening a command terminal and typing:
    ```bash
    java -version
   
    ```
    If you need `Java`, you can download it from [Java Downloads](https://www.oracle.com/java/technologies/downloads/).

2. Download the latest `.jar` file from [EZSTATES Releases](https://github.com/AY2425S1-CS2103T-F11-4/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for EZSTATE.

4. Open a command terminal and navigate to the folder with the `.jar` file by typing:
    ```bash
    cd path/to/your/folder

    ```
    <div class="note" markdown="span">
    (Windows Users) Alternatively, you can open the folder where the `.jar` file  is located,
    right click on any space inside the folder and click `Open in Terminal`.
    </div>

   Then run the app with:
    ```bash
    java -jar ezstate.jar
   
    ```
   
   A GUI should appear in a few seconds as shown below. **Note that the initial launch of the app will contain some sample data**.<br><br>
   ![Ui](images/Ui.png)<br><br>

### Basic Commands
To use **EZSTATE**, type commands in the command box and press `Enter`. Here are a few to try:

   * `help` : Opens the help window showing all commands.

   * `showclients` : Lists all contacts in the system.

   * `buyer n/John Doe p/98765432 e/johnd@example.com` : Adds a buyer named `John Doe` with a phone number `98765432` and email `johnd@example.com`.

   * `delete 1` : Deletes the contact at index 1.(e.g. "Alex Yeoh" according to the picture above).

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

<div class="note" markdown="span">
Explore the Features section for a full list of commands and their uses.
</div>

### Command Structure

In this section, we will explore the command structure in **EZSTATE** before delving into the **Features** section. 
Understanding the command structure in **EZSTATE** is essential for efficient navigation and use of the app’s features. 
Each command in **EZSTATE** is designed to follow a clear, consistent format, allowing you to manage clients, listings, and appointments with precision and speed. 
By mastering this structure, you will find it easier to remember commands and customize inputs, making your experience smoother and enabling you to accomplish tasks more effectively. 

This section breaks down the structure, reference, and prefixes used across all commands, so you can quickly become proficient with **EZSTATE**.

Commands in **EZSTATE** follow the same structure:

`commandWord (REFERENCE) (PREFIXES)` 

| commandWord                  | REFERENCE                                                                                                            | PREFIXES                                                                                                 |
|------------------------------|----------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| Specifies the command to run | Comes before all prefixes and is used to make reference a particular client/listing <br/> Optional for some commands | Used to specify various attributes/properties for a given `commandWord` <br/> Optional for some commands |

#### Reference Types

| Reference | Meaning                                  | Constraints                                                     | Remarks                                                                                                        |
|-----------|------------------------------------------|-----------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|
| INDEX     | INDEX of a client or a listing in a list | INDEX are positive integers that are `one-based` (i.e. `>= 1`). | Commonly used in edit and delete clients/listings to make reference to these objects in their respective lists |

#### Prefix Notation

Prefixes follow the same structure

`prefix/Value`

and can be either optional or mandatory, and variadic or not variadic.
The table below showcases the four different possible notations of prefixes:

|              | Mandatory       | Optional          |
|--------------|-----------------|-------------------|
| Not variadic | prefix/Value    | [prefix/Value]    |
| Variadic     | prefix/Value... | [prefix/Value]... |

<div class="note" markdown="span">
Optional fields can be omitted and the command will still be executed successfully <br> _(assuming all other parts are correctly inputted)_ 
</div>

#### Prefix Types

<div class="note" markdown="span">
The prefixes used in **EZSTATE** are universal across all commands <br> _(i.e. have the same constraints and remarks)_
</div>
<br>

| Prefix | Meaning | Location       | Constraints | Remarks                                                                                           | Example                                                                                 |
|--------|---------|----------------|-------------|---------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| n/     | name    | Client/Listing |             | -                                                                                                 |                                                                                         |
| p/     | phone   | Client         |             | -                                                                                                 |                                                                                         |
| e/     | email   | Client         |             | -                                                                                                 |                                                                                         |
| t/     | tag     | Client         |             | -                                                                                                 |                                                                                         |
| d/     | date    | Appointment    |             | Unique to `apt` command.                                                                          |                                                                                         |
| fr/    | from    | Appointment    |             | Unique to `apt` command.                                                                                                 |                                                                                         |
| to/    | to      | Appointment    |             | Unique to `apt` command.                                                                                                |                                                                                         |
| pr/    | price   | Listing        |             | Unique to `listing` command.                                                                      | listing n/Warton House pr/4000 ar/1000 add/123 PASIR RIS (S)123456 reg/east sel/2 buy/1                                                                                        |
| ar/    | area    | Listing        |             | Unique to `listing` command.                                                                      | listing n/Warton House pr/4000 ar/1000 add/123 PASIR RIS (S)123456 reg/east sel/2 buy/1                                                                                        |
| add/   | address | Listing        |             | Unique to `listing` command.                                                                      | listing n/Warton House pr/4000 ar/1000 add/123 PASIR RIS (S)123456 reg/east sel/2 buy/1                                                                                        |
| reg/   | region  | Listing        |             | Unique to `listing` command.                                                                      | listing n/Warton House pr/4000 ar/1000 add/123 PASIR RIS (S)123456 reg/east sel/2 buy/1                                                                                        |
| sell/  | seller  | Listing        |             | In `listing`, sell is used instead of seller to refer to the seller of the listing.               | listing n/Warton House pr/4000 ar/1000 add/123 PASIR RIS (S)123456 reg/east sel/2 buy/1 |
| buy/   | buyer   | Listing        |             | In `addlistingbuyers` and `removelistingbuyers`, buy is used instead of buyer to refer to buyers. | addlistingbuyers 1 buy/Charlotte Oliveiro                                               |

--------------------------------------------------------------------------------------------------------------------

## Feature Categories

<div class="alert" markdown="span">
You are strongly recommended to read through [Command Structure](#CommandStructure) before proceeding with this section!
</div>

<br>
This user guide is divided into four main feature categories:

1. **Client Management Commands**
2. **Appointment Management Commands**
3. **Listing Management Commands**
4. **Utility Commands**

---

### **1. Client Management Commands**

Commands for creating, updating, and deleting buyers and sellers.

![showClients](images/Ui.png)

- #### Add Buyer Command
    - **Format:** `buyer n/NAME p/PHONE e/EMAIL [t/TAG]...`
    - **Description:** Creates a new buyer profile with specified details.
    - **Successful Execution:**
      > ---
      >
      > **Use Case #1**: Adding a buyer named `Bobby` with phone number `91124444` and email `john123@gmail.com`
      >
      > **Input**: `buyer n/Bobby p/91124444 e/bobby123@gmail.com`
      >
      > **Output**: New buyer added: Bobby; Phone: 91124444; Email: bobby123@gmail.com; Appointment: -; Tags:
      >
      > ---
      >
      > **Use Case #2**: Adding a buyer named `Bobby` with phone number `91124444`, email `john123@gmail.com`, tags `friend`, `owner`
      >
      > **Input**: `buyer n/Bobby p/91124444 e/bobby123@gmail.com t/friend t/owner`
      >
      > **Output**: New buyer added: Bobby; Phone: 91124444; Email: bobby123@gmail.com; Appointment: -; Tags: [owner][friend]
      >
      > ---
   
    <br>
    <div class="note" markdown="span">
    NAME is case-insensitive: 
    `buyer n/Bob` = `buyer n/BOB` = `buyer n/bOb` _(Not exhaustive)_
  
    Thus, if a buyer/seller with the same name already exists, the commands above cannot be executed
    as they result in a duplicate buyer created
    </div>
    <br>

    - **Failed Execution:**
      > ---
      >
      > **User Error #1**: Missing `NAME` field
      >
      > **Input**: `buyer p/91124444 e/bobby123@gmail.com`
      >
      > **Output**: <br>
      Invalid command format! <br>
      buyer: Adds a buyer to the address book. <br>
      Parameters: n/NAME p/PHONE e/EMAIL [t/TAG]...<br>
      Example: buyer n/John Doe p/98765432 e/johnd@example.com> t/friends t/owesMoney
      >
      > ---
      >
      > **User Error #2**: Missing `PHONE` field
      >
      > **Input**: `buyer n/Bobby e/bobby123@gmail.com`
      >
      > **Output**: <br>
      Invalid command format! <br>
      buyer: Adds a buyer to the address book. <br>
      Parameters: n/NAME p/PHONE e/EMAIL [t/TAG]...<br>
      Example: buyer n/John Doe p/98765432 e/johnd@example.com> t/friends t/owesMoney
      >
      > ---
      >
      > **User Error #3**: Missing `EMAIL` field
      >
      > **Input**: `buyer n/Bobby p/91124444`
      >
      > **Output**: <br>
      Invalid command format! <br>
      buyer: Adds a buyer to the address book. <br>
      Parameters: n/NAME p/PHONE e/EMAIL [t/TAG]...<br>
      Example: buyer n/John Doe p/98765432 e/johnd@example.com> t/friends t/owesMoney
      >
      > **User Error #4**: Buyer already exists 
      > 
      > **Input**: `buyer n/Bobby p/83485111 e/bobby1234@gmail.com` <br>_(Assuming name `Bobby` already exists)_
      > 
      > **Output**: This buyer already exists in the address book
      > 
      > ---
- #### Add Seller Command
    - **Format:** `seller n/NAME p/PHONE e/EMAIL [t/TAG]...`
    - **Description:** Creates a new seller profile with specified details.
    - **Successful Execution:**
      > ---
      > **Use Case #1**: Adding a seller named `Bobby` with phone number `91124444` and email `john123@gmail.com`
      >
      > **Input**: `seller n/Bobby p/91124444 e/bobby123@gmail.com`
      >
      > **Output**: New seller added: Bobby; Phone: 91124444; Email: bobby123@gmail.com; Appointment: -; Tags:
      >
      > ---
      >
      > **Use Case #2**: Adding a seller named `Bobby` with phone number `91124444`, email `john123@gmail.com`, tags `friend`, `owner`
      >
      > **Input**: `seller n/Bobby p/91124444 e/bobby123@gmail.com t/friend t/owner`
      >
      > **Output**: New seller added: Bobby; Phone: 91124444; Email: bobby123@gmail.com; Appointment: -; Tags: [owner][friend]
      >
      > ---

    <br>
    <div class="note" markdown="span">
    NAME is case-insensitive: 
    `seller n/Bob` = `seller n/BOB` = `seller n/bOb` _(Not exhaustive)_
    <br>
    If a buyer/seller with the same name already exists, the equivalent commands above cannot be carried out
    </div>
    <br>

    - **Failed Execution**
      > ---
      > **User Error #1**: Missing `NAME` field
      >
      > **Input**: `seller p/91124444 e/bobby123@gmail.com`
      >
      > **Output**: <br>
        Invalid command format! <br>
        seller: Adds a seller to the address book. <br>
        Parameters: n/NAME p/PHONE e/EMAIL [t/TAG]...<br>
        Example: seller n/John Doe p/98765432 e/johnd@example.com> t/friends t/owesMoney
      >
      > ---
      >
      > **User Error #2**: Missing `PHONE` field
      >
      > **Input**: `seller n/Bobby e/bobby123@gmail.com`
      >
      > **Output**: <br>
        Invalid command format! <br>
        seller: Adds a seller to the address book. <br>
        Parameters: n/NAME p/PHONE e/EMAIL [t/TAG]...<br>
        Example: seller n/John Doe p/98765432 e/johnd@example.com> t/friends t/owesMoney
      >
      > ---
      > **User Error #3**: Missing `EMAIL` field
      >
      > **Input**: `seller n/Bobby p/91124444`
      >
      > **Output**: <br>
        Invalid command format! <br>
        seller: Adds a seller to the address book. <br>
        Parameters: n/NAME p/PHONE e/EMAIL [t/TAG]...<br>
        Example: seller n/John Doe p/98765432 e/johnd@example.com> t/friends t/owesMoney
      >
      > ---
      > 
      > **User Error #4**: Seller already exists
      > 
      > **Input**: `seller n/Bobby p/83485111 e/bobby1234@gmail.com` <br>_(Assuming name `Bobby` already exists)_ 
      > 
      > **Output**: This buyer already exists in the address book
      > 
      >  ---

- #### Find Command
    - **Format:** `find KEYWORD [KEYWORD]...`
    - **Description:** Finds the specified client(s) based on the provided keywords.
    - **Successful Execution:**
      > ---
      > **Use Case #1**: Finding `Bob`
      >
      > **Input**: `find Bob`
      >
      > **Output**: 1 persons listed!
      >
      > ![bob](images/bob.png)
      >
      > ---
      >
      > **Use Case #2**: Finding `Bob` OR `Winter`
      >
      > **Input**: `find Bob Winter`
      >
      > **Output**: 2 persons listed!
      >
      > ![bobwinter](images/bob_winter.png)
      >
      > ---

    <br>
    <div class="note" markdown="span">
    NAME is case-insensitive: 
    `find Bob` = `find BOB` = `find bOb` _(Not exhaustive)_
    </div>
    <br>

    <div class="alert" markdown="span">
    However, NAME is space-sensitive:
    `find Wen Xuan` != `find WenXuan`
    <br>
    <br>
    First command finds names with `wen` OR `xuan`
    <br>
    Second command finds names with `wenxuan`
    </div> 
    <br>    

    - **Failed Execution:**
      > ---
      >
      > **Use Case**: Client not found
      > 
      > **Input**: `find Bob7`
      > 
      > **Output**: 0 persons listed!
      > 
      > ![noclients](images/no_clients.png)
      > 
      > ---

- #### Edit Client Command
    - **Format:** `editclient INDEX [n/NAME] [p/PHONE] [e/EMAIL] [t/TAG]...`
    - **Description:** Edits the details of the specified client.
    - **Successful Execution:**
      > ---
      > **Use Case #1**: Changing name of `Bob` to `Bobby` (Assuming displayed index is 1)
      >
      > **Input**: `editclient 1 n/Bobby`
      >
      > **Output**: Successfully edited Bobby; Phone: 91124444; Email: bobby123@gmail.com; Appointment: -; Tags: [owner][friend]!
      >
      > ---
      >
      > **Use Case #2**: Changing phone of `Bobby` to `97774444` 
      >
      > **Input**: `editclient 1 p/97774444`
      >
      > **Output**: 
      > Successfully edited Bobby.
      > Phone number: 97774444 and Email: bobby123@gmail.com!
      >
      > ---
      >
      > **Use Case #3**: Removing tags of `Bobby`
      >
      > **Input**: `editclient 1 t/`
      >
      > **Output**: 
      > Successfully edited Bobby. 
      > Phone number: 97774444 and Email: bobby123@gmail.com!
      >
      > ---

    - **Failed Execution:**
      > ---
      > **User Error #1**: No index found / Invalid type / Negative integer
      >
      > **Input**: `editclient n/Bobby` OR `editclient #a` OR `editclient -1`
      >
      > **Output**:
      <br> Invalid command format!
      <br>edit: Edits the details of the person identified by their name. Existing values will be overwritten by the input values.
      <br>Parameters: INDEX (must be a positive integer) [n/NAME] [p/PHONE] [e/EMAIL] [t/TAG]...
      <br>Example: editclient 1 e/johndoe@example.com p/91234567
      >
      > ---
      > 
      > **User Error #2**: Entering out-of-bounds index (larger than number of clients)
      > 
      > **Input**: `editclient 100 n/Bobby`
      > 
      > **Output**: The person index provided is invalid
      > 
      > ---

- #### Delete Client Command
    - **Format:** `deleteclient INDEX`
    - **Description:** Deletes the specified client profile.
    - **Successful Execution:**
      > ---
      > **Use Case #1**: Delete `Bob` from the address book (Assuming displayed index is 1)
      >
      > **Input**: `deleteclient 1`
      >
      > **Output**: `Successfully deleted Bob.
      Phone number: 977774444 and Email: bobby123@gmail.com`
      >
      > ---
  
    - **Failed Execution:**
      > ---
      > **Use Case #1**: No index found / Invalid type / Negative integer
      >
      > **Input**: `deleteclient` OR `deleteclient #a` OR `deleteclient -1`
      >
      > **Output**: 
      <br> Invalid command format! 
      <br>delete: Deletes the client profile corresponding to the client's name.
      <br>Parameters: INDEX (must be a positive integer)
      <br>Example: delete 1
      >
      > ---
      > **Use Case #2**: Entering out-of-bounds index (larger than number of clients)
      > 
      > **Input**: `deleteclient 100`
      > 
      > **Output**: The person index provided is invalid
      > 
      > ---

---

### **2. Appointment Management**

Commands for managing appointments between user and clients.

![appointments](images/appointments.png)

- #### Schedule Appointment
    - **Format:** `apt INDEX d/DD-MM-YY fr/HHmm to/HHmm` OR `apt INDEX d/ddMMyy fr/HH:mm to/HH:mm`
    - **Description:** Schedules a new appointment to be held with the specified client that includes the specified details (date, time).<br>
    - **Successful Execution:**
      > ---
      > **Use Case #1**: Adding appointment `8th October 2024 7pm to 9pm` for client `Bob` (Assuming displayed index is 1)
      >
      > **Input**: `apt 1 d/08-10-24 fr/1900 to/2100`
      >
      > **Output**: Appointment scheduled for Bob; Phone: 94441111; Email: bob123@gmail.com; Appointment: Date: 08-10-24 (From: 19:00 To: 21:00); Tags:
      >
      > ![bob_apt](images/bob_apt.png)
      > 
      > ---
      >
      > **Use Case #2**: Overriding an existing appointment for client `Bob` to be `9th October 2024 10am to 12pm` instead
      >
      > **Input**: `apt 1 d/09-10-24 fr/1000 to/1200`
      >
      > **Output**: Appointment scheduled for Bob; Phone: 94441111; Email: bob123@gmail.com; Appointment: Date: 09-10-24 (From: 10:00 To: 12:00); Tags:
      >
      > ![bob_apt_2](images/bob_apt_2.png)
      > 
      > ---
  
    - **Failed Execution:**
      > ---
      > **Use Case #1**: Incorrect `DATE` format 
      >
      > **Input #a**: `apt 1 d/09-10-2024 fr/1000 to/1200`
      >
      > **Input #b**: `apt 1 d/aaa fr/1000 to/1200`
      > 
      > **Output**: Dates should be in the format dd-MM-yy or ddMMyy, e.g., 25-12-24 or 251224.
      >
      > ---
      > 
      > **Use Case #2**: Incorrect `TIME` format
      > 
      > **Input #a**: `apt 1 d/20-10-24 fr/100000 to/1200`
      > 
      > **Input #b**: `apt 1 d/20-10-24 fr/aa to/1200`
      > 
      > **Output**: Times should be in the format HH:mm or HHmm, e.g., 0900 or 09:00.
      > 
      > ---

- #### Delete Appointment
    - **Format:** `delapt INDEX`
    - **Description:** Deletes an appointment with the specified client.
    - **Successful Execution:**
      > ---
      > **Use Case**: Deleting appointment for `Bob` (Assuming displayed index is 1)
      >
      > **Input**: `delapt 1`
      >
      > **Output**: Successfully deleted appointment from Bob
      >
      > ![bobdeletedappt](images/bob_del_apt.png)
      > 
      > ---

    - **Failed Execution:**
      > ---
      > **Use Case**: Entering out-of-bounds index (larger than number of clients)
      >
      > **Input**: `delapt 100`
      >
      > **Output**: The person index provided is invalid
      >
      > ---
      
---

### **3. Listing Management**

Commands for managing property listings and associating clients with listings.

![showListings](images/showListings.png)

- #### Add Listing
    - **Format:** `listing n/NAME pr/PRICE ar/AREA add/ADDRESS reg/REGION sel/SELLER_INDEX [buy/BUYER_INDEX]...`
    - **Description:** Adds a new listing associated to the seller with the specified details.
    - **Successful Execution:**
      > ---
      > **Use Case #1**: Adding a listing with name `Warton House`, price `4000`, area `1000`, address `123 PASIR RIS (S)123456`, region `east`, seller `Bernice Yu`, buyer `Alex Yeoh`  
      >
      > **Input**: `listing n/Warton House pr/4000 ar/1000 add/123 PASIR RIS (S)123456 reg/east sel/2 buy/1`
      >
      > **Output**: New listing added: Warton House; Price: 4000; Area: 1000; Region: EAST; Address: 123 PASIR RIS (S)123456; Seller: seedu.address.model.person.Seller{name=Bernice Yu, phone=99272758, email=berniceyu@example.com, tags=[[colleagues], [friends]], appointment=-, remark=No remarks yet.}seedu.address.model.person.Buyer{name=Alex Yeoh, phone=87438807, email=alexyeoh@example.com, tags=[[friends]], appointment=Date: 20-12-24 (From: 08:00 To: 10:00), remark=Test}
      >
      > ![listing](images/warton_house_listing.png)
      > 
      > ---
      >
      > **Use Case #2**: Adding a listing with no buyers
      >
      > **Input**: `listing n/Warton House pr/4000 ar/1000 address/123 PASIR RIS (S)123456 reg/east sel/2`
      >
      > **Output**: New listing added: Warton House; Price: 4000; Area: 1000; Region: EAST; Address: 123 PASIR RIS (S)123456; Seller: seedu.address.model.person.Seller{name=Bernice Yu, phone=99272758, email=berniceyu@example.com, tags=[[colleagues], [friends]], appointment=-, remark=No remarks yet.}
      >
      > ![listing2](images/warton_house_no_buyers.png)
      > 
      > ---

    - **Failed Execution:**
      > ---
      > **Use Case #1**: Attempting to add a listing for a non-existent seller
      >
      > **Input**: `listing n/Warton House pr/4000 ar/1000 add/123 PASIR RIS (S)123456 reg/east sel/100`
      >
      > **Output**: The seller index provided is invalid!
      >
      > ---
      > 
      > **Use Case #2**: Attempting to add non-existent buyers to a listing
      > 
      > **Input**: `listing n/Warton House pr/4000 ar/1000 add/123 PASIR RIS (S)123456 reg/east sel/2 buy/100`
      > 
      > **Output**: The buyer index (100) provided is invalid!
      > 
      > ---

- #### Show Listings
    - **Format:** `showlistings`
    - **Description:** Displays all current listings.
    - **Successful Execution:**
      > ---
      > **Use Case #1**: To show all listings in the addressbook
      >
      > **Input**: showlistings
      >
      > **Output**: Here are your listings!
      >
      > ![showlistings](images/showListings.png)
      > 
      > ---
      > 
      > **Use Case #2**: To show all listings (when there are none)
      > 
      > **Input**: showlistings
      > 
      > **Output**: You have no listings available.
      > 
      > ![nolistings](images/no_listings.png)
      > 
      > ---

    - **Failed Execution:** NIL

- #### Add Buyers to Listing
    - **Format:** `addlistingbuyers INDEX buy/BUYER_INDEX [buy/MORE_BUYER_INDEXES...]`
    - **Description:** Associates buyers with a specified listing.
    - **Successful Execution:**
      > ---
      > **Use Case #1**: Adding one buyer `Alex Yeoh` to listing `RC4` (Assuming displayed index is 1)
      >
      > **Input**: `addlistingbuyers 1 buy/1 buy/3`
      >
      > **Output**: Buyers added to listing: RC4
      >
      > ---
      >
      > **Use Case #2**: Adding two buyers `Alex Yeoh` and `Charlotte Oliveiro` to listing `David HDB`
      >
      > **Input**: `addlistingbuyers 2 buy/1 buy/3`
      >
      > **Output**: Buyers added to listing: David HDB
      >
      > ---
    
    - **Failed Execution:**
      > ---
      > **Use Case #1**: Listing not found
      >
      > **Input**: `addlistingbuyers 100 buy/1`
      >
      > **Output**: The listing index provided is invalid!
      >
      > ---
      > 
      > **User Error #2**: Duplicate buyers
      > 
      > **Input**: `addlistingbuyers 1 buy/1` <br>_(Assuming RC4 contains Alex Yeoh already)_
      > 
      > **Output**: Some buyers are already associated with this listing.
      > 
      > --- 
      > 
      > **User Error #3**: Buyer not found
      > 
      > **Input**: `addlistingbuyers 1 buy/100`
      > 
      > **Output**: The person index provided is invalid!
      > 
      > ---
      > 
      > **User Error #4**: Person is not a buyer
      > 
      > **Input**: `addlistingbuyers 1 buy/1` <br>_(Assuming client 1 is a seller)_
      > 
      > **Output**: The specified person is not a buyer:<br>1.bob
      > 
      >
      > ---

- #### Remove Buyers from Listing
    - **Format:** `removelistingbuyers INDEX buy/BUYER INDEX [buy/MORE_BUYER_INDEXES...]`
    - **Description:** Removes buyers associated with a specified listing.
    - **Successful Execution:**
      > ---
      > **Use Case #1**: Removing one buyer `Alex Yeoh` from listing `RC4`
      >
      > **Input**: `removelistingbuyers 1 buy/1` 
      >
      > **Output**: Buyers removed from listing: RC4
      >
      > ---
      >
      > **Use Case #2**: Removing two buyers `Alex Yeoh` and `Charlotte Oliveiro` from listing `RC4`
      >
      > **Input**: `removelistingbuyers 1 buy/1 buy/3`
      >
      > **Output**: Buyers removed from listing: RC4
      >
      > ---

    - **Failed Execution:**
      > ---
      > **User Error #1**: Listing not found
      >
      > **Input**: `removelistingbuyers 100 buy/1`
      >
      > **Output**: The listing index provided is invalid!
      > 
      > ---
      > 
      > **User Error #2**: Empty set of buyers
      >
      > **Input**: `removelistingbuyers 1 buy/`
      >
      > **Output**: The person index provided is invalid!
      > 
      > ---
      > 
      > **User Error #3**: Person specified is not buyer
      >
      > **Input**: `removelistingbuyers 1 buy/2`
      >
      > **Output**: The person index provided is invalid!
      > 
      > ---
      > 
      > **User Error #4**: Person specified is not a buyer for the listing
      >
      > **Input**: `removelistingbuyers 1 buy/3`
      >
      > **Output**: The specified buyer notInterestedBuyer is not a buyer of the listing RC4.
      > 
      > ---
      > 
      > **User Error #5**: Buyer not found
      >
      > **Input**: `removelistingbuyers 1 buy/100`
      >
      > **Output**: The specified buyer nonExistentBuyer does not exist in the client list.
      > 
      > ---

- #### Delete Listing
    - **Format:** `deletelisting INDEX`
    - **Description:** Deletes a specified listing.
    - **Successful Execution:**
      > ---
      > **Use Case #1**: Deleting listing `Warton House` (Assuming displayed index is 1)
      >
      > **Input**: `deletelisting 1`
      >
      > **Output**: Successfully deleted listing: Warton House
      >
      > ---

    - **Failed Execution:**
      > ---
      > **Use Error**: Listing not found
      >
      > **Input**: deletelisting 100
      >
      > **Output**: This listing does not exist in EZSTATE
      >
      > ---

- #### Clear Listing
    - **Format:** `clearlistings`
    - **Description:** Deletes ALL listings.
    - **Successful Execution:**
      > ---
      > **Use Case**: Clear all listings in addressbook
      >
      > **Input**: clearlistings
      >
      > **Output**: All listings have been cleared!
      >
      > ---

### **4. Utility Commands**

Miscellaneous commands for application utility, such as clearing, exiting, and displaying help.

- #### Clear
    - **Format:** `clear`
    - **Description:** Clears all clients and listings.
    - **Successful Execution:**
      > ---
      > **Use Case**: Fresh addressbook and listings
      >
      > **Input**: clear
      >
      > **Output**: Address book and listings has been cleared!
      >
      > ---

- #### Exit
    - **Format:** `exit`
    - **Description:** Exits the application.
    - **Successful Execution:**
      > ---
      > **Use Case**: Exit the application
      >
      > **Input**: exit
      > 
      > **Output**: Exiting Address Book as requested ...
      >
      > ---
      
- #### Help
    - **Format:** `help`
    - **Description:** Displays a list of available commands and their descriptions.
    - **Successful Execution:**
      > ---
      > **Use Case**: Accessing help
      >
      > **Input**: `help`
      >
      > **Output**: Opened help window.
      >
      > ![help](images/help.png)
      > 
      > ---
    
    <br>
    <div class="alert" markdown="span">
    WARNING: The subsequent section `More Info` might have an outdated command format. This is as of `v1.5`.<br>
    <br>
    Please refer to the command format given in the application as per the app version used.
    </div>

- #### More Info
    - **Format:** `moreinfo NAME`
    - **Description:** Provides additional information about a specific client.
    - **Successful Execution:**
      > ---
      > **Use Case**: Finding out more information about `Bob`
      >
      > **Input**: `moreinfo Bob`
      >
      > **Output**: Opened window for client's information.
      >
      > ![moreinfo](images/moreinfo.png)
      > 
      > ---

    <br>
    <div class="note" markdown="span">
    NAME is case-insensitive: 
    `moreinfo Bob` = `moreinfo BOB` = `moreinfo bOb` _(Not exhaustive)_

    Thus, these commands will provide more information about the same `Bob` client
    </div>
    <br>

    <div class="alert" markdown="span">
    However, NAME is space-sensitive:
    `moreinfo wen xuan` != `moreinfo wenxuan`
    
    These commands will provide more information about different clients
    </div> 
    <br>

    - **Failed Execution:**
      > ---
      > **Use Case**: Client not found
      >
      > **Input**: moreinfo nonExistentClient
      >
      > **Output**: Please enter an existing client name!
      >
      > ---

- #### Chat Window
    - **Format:** `chatbot`
    - **Description:** Opens a chatbot that answers basic queries.
    - **Successful Execution:**
      > ---
      > **Use Case #1**: Valid Greeting
      >
      > **Input**:
      ![validGreeting.png](images%2FvalidGreeting.png)
      **Output**:
      ![outputFromValidGreeting.png](images%2FoutputFromValidGreeting.png)
      > ---
      >
      > **Use Case #2**: Valid Query
      >
      > **Input**:
      ![validQuery.png](images%2FvalidQuery.png)
       **Output**:
      ![outputFromValidQuery.png](images%2FoutputFromValidQuery.png)
      > ---
      >
      > **Use Case #3**: Valid Farewell
      >
      > **Input**:
      ![validGoodbye.png](images%2FvalidGoodbye.png)
      **Output**:
      ![outputFromValidGoodbye.png](images%2FoutputFromValidGoodbye.png)
      > ---

      - **Failed Execution:**
      > ---
      > **Use Case #1**: Invalid Query
      >
      > **Input**:
      ![invalidInput.png](images%2FinvalidInput.png)
      >
      > **Output**:
      ![outputOfInvalidInput.png](images%2FoutputOfInvalidInput.png)
      > ---


### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

 Action     | Format, Examples                                                                                                                    
------------|-------------------------------------------------------------------------------------------------------------------------------------
 **Add**    | `add n/NAME p/PHONE_NUMBER e/EMAIL​` <br> e.g. `add n/James Ho p/22224444 e/jamesho@example.com`                                    
 **Clear**  | `clear`                                                                                                                             
 **Delete** | `delete NAME`<br> e.g. `delete James Ho`                                                                                            
 **Edit**   | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL]​`<br> e.g.`edit 2 n/James Lee e/jameslee@example.com` <br> e.g.`edit 2 n/James Voo` 
 **Find**   | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`                                                                          
 **List**   | `list`                                                                                                                              
 **Help**   | `help`                                                                                                                              
