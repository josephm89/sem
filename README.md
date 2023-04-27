<h1>A Portable Software Application. With The Centric Focus Of Providing Detailed Reports On Specific Geographical Demographics Provided By An Organisational Database</h1>
<hr/>

* ![GitHub Workflow Status (with branch)](https://img.shields.io/github/actions/workflow/status/josephm89/sem/main.yml?branch=master&label=master&style=flat-square)
* ![GitHub Workflow Status (with branch)](https://img.shields.io/github/actions/workflow/status/josephm89/sem/main.yml?branch=develop&label=develop&style=flat-square)
* ![GitHub Workflow Status (with branch)](https://img.shields.io/github/actions/workflow/status/josephm89/sem/main.yml?branch=release&label=release&style=flat-square)
* [![LICENSE](https://img.shields.io/github/license/josephm89/sem.svg?style=flat-square)](https://github.com/josephm89/sem/blob/master/LICENSE)
* [![Releases](https://img.shields.io/github/release/josephm89/sem/all.svg?style=flat-square)](https://github.com/josephm89/sem/releases)

| ID | Requirement Name | Met Requirement? | Screenshot                                                 |
|----|------------------|------------------|------------------------------------------------------------|
| 1  | All the countries in the world organised by largest population to smallest.       | Yes              | [![Screenshot A](/screenshots/1.png)](/screenshots/2.png)  |
| 2  | All the countries in a continent organised by largest population to smallest.       | Yes              | [![Screenshot A](/screenshots/2.png)](/screenshots/2.png)  |
| 3  | All the countries in a region organised by largest population to smallest.        | Yes              | [![Screenshot A](/screenshots/3.png)](/screenshots/2.png)  |
| 4  | The top N populated countries in the world where N is provided by the user.       | Yes              | [![Screenshot A](/screenshots/4.png)](/screenshots/2.png)  |
| 5  | The top N populated countries in a continent where N is provided by the user.       | Yes              | [![Screenshot A](/screenshots/5.png)](/screenshots/2.png)  |
| 6  | The top N populated countries in a region where N is provided by the user.       | Yes              | [![Screenshot A](/screenshots/6.png)](/screenshots/2.png)  |
| 7  | All the cities in the world organised by largest population to smallest.       | Yes              | [![Screenshot A](/screenshots/7.png)](/screenshots/2.png)  |
| 8  | All the cities in a continent organised by largest population to smallest.       | Yes              | [![Screenshot A](/screenshots/8.png)](/screenshots/2.png)  |
| 9  | All the cities in a region organised by largest population to smallest.       | Yes              | [![Screenshot A](/screenshots/9.png)](/screenshots/2.png)  |
| 10 | All the cities in a country organised by largest population to smallest.       | Yes              | [![Screenshot A](/screenshots/10.png)](/screenshots/2.png) |
| 11 | All the cities in a district organised by largest population to smallest.       | Yes              | [![Screenshot A](/screenshots/11.png)](/screenshots/2.png) |
| 12 | The top N populated cities in the world where N is provided by the user.      | Yes              | [![Screenshot A](/screenshots/12.png)](/screenshots/2.png) |
| 13 | The top N populated cities in a continent where N is provided by the user.      | Yes              | [![Screenshot A](/screenshots/13.png)](/screenshots/2.png) |
| 14 | The top N populated cities in a region where N is provided by the user.       | Yes              | [![Screenshot A](/screenshots/14.png)](/screenshots/2.png) |
| 15 | The top N populated cities in a country where N is provided by the user.       | Yes              | [![Screenshot A](/screenshots/15.png)](/screenshots/2.png) |
| 16 | The top N populated cities in a district where N is provided by the user.       | Yes              | [![Screenshot A](/screenshots/16.png)](/screenshots/2.png) |
| 17 | All the capital cities in the world organised by largest population to smallest.       | Yes              | [![Screenshot A](/screenshots/17.png)](/screenshots/2.png) |
| 18 | All the capital cities in a continent organised by largest population to smallest.     | Yes              | [![Screenshot A](/screenshots/19.png)](/screenshots/2.png) |
| 19 | All the capital cities in a region organised by largest to smallest.     | Yes              | [![Screenshot A](/screenshots/19.png)](/screenshots/2.png) |
| 20 | The top N populated capital cities in the world where N is provided by the user.       | Yes              | [![Screenshot A](/screenshots/20.png)](/screenshots/2.png) |
| 21 | The top N populated capital cities in a continent where N is provided by the user.       | Yes              | [![Screenshot A](/screenshots/21.png)](/screenshots/2.png) |
| 22 | The top N populated capital cities in a region where N is provided by the user.       | Yes              | [![Screenshot A](/screenshots/22.png)](/screenshots/2.png) |


<h2>Our Approach</h2>
<p>To achieve the desired reports, our team will focus on the creating the desired software via the following steps:</p>
<ul>
  <li>Understanding the SQL database structure and contents.</li>
  <li>Analyzing the report requirements and breaking them down into smaller, manageable tasks.</li>
  <li>Developing a plan for organising and delegating tasks among team members.</li>
  <li>Implementing the report generation functionality and testing it against the requirements.</li>
  <li>Refining and debugging the solution as needed, utilising develop, release, and master branches.</li>
</ul>

<h2>Project Workflow</h2>
<p>Our project utilises the renowned Gitflow version control workflow consisting of designing our software within three main Github branches: master, develop, and release.</p>

<h3>Master Branch</h3>
<p>The master branch represents the production-ready code and contains only the latest, stable releases of the software.</p>

<h3>Develop Branch</h3>
<p>The develop branch is where all the new features and bug fixes are added and integrated into the code. This is the main branch for active development and is constantly updated as new changes are made.</p>

<h3>Release Branch</h3>
<p>The release branch is created from the develop branch and is used to prepare a new release of the software. This branch includes the necessary bug fixes, changes, and testing before the software is finally merged into the master branch and released. Once a release is completed, the release branch is deleted, and the cycle starts over with a new release branch created from the updated develop branch.</p>

<h2>Database</h2>
<p>The provided SQL database will serve as the foundation for our population reporting system. Our team will take the time to familiarize ourselves with the database structure and contents to ensure that our solution is effective and efficient.</p>

<h2>Communication</h2>
<p>A private discord server has been established for the SCRUM team members to communicate in a focal environment with the necessary security protocols for discussing software architecture in a way which can be truly transparent.</p>

<h2>Architecture</h2>
<ul>
  <li>Java version 11 - to ensure all team members are running a synchronized version compatible with team software and hardware facilities</li>
  <li>MySql - A SQL server which will run the provided SQL database and will be shared amongst the team</li>
  <li>Git - Version Control for the team to contribute to the project collaboratively and on a non-local basis</li>
  <li>GitHub - To host the Git project</li>
  <li>Docker - To run both the SQL server and the Java project in a containerized environment with universally assigned toolkits and dependencies</li>
  <li>Intellij IDEA Community - An Easy to use IDE with streamlined Git Version Control and Java oriented features</li>
 </ul>
<h2>Conclusion</h2>
<p>Our team is committed to providing a comprehensive, efficient, and effective solution to the population reporting system. With a clear approach, individual contributions, a streamlined Gitflow workflow, a solid foundation in the SQL database, efficient communication, and a well-defined architecture, we are confident in our ability to deliver the desired reports.</p>


