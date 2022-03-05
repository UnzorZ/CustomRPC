CustomRPC Changer
======================


CustomRPC is a tool that allows you to change your discord rich presence (RPC) to a custom one. It also allows creating sentence sequences 

# Requirements

You will need to create an application at the [discord developer portal](https://discord.com/developers/applications/) clicking in **New Application**. You will need to enter a name for the application (keep in mind that the name will appear at the top of the RPC [example](https://imgur.com/llnGmOx)). Go to the **Rich Presence** section and enable it if needed. In **Art Assets** you can upload your photos (it doesn't matter if you want a photo for the big image or the small one).



# How to use it

Using this program is easy. Download the jar from [Releases](https://github.com/UnzorZ/CustomRPC-WIP/releases) and open it just double-clicking it.

The program should ask you for this requirements:

| Data asked       | What is that                                                                                                                                                          |
|------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| First line       | Is the first line of the Rich presence [example](https://imgur.com/llnGmOx)                                                                                           |
| Second line      | Is the second line of the Rich presence [example](https://imgur.com/llnGmOx)                                                                                          |
| Large image name | Name of the image updated in the [discord developer portal](https://discord.com/developers/applications/)                                                             |
| Large image text | Text that appears when you put your mouse on top of the big image [example](https://imgur.com/4BBJEja)                                                                |
| Small image name | Name of the small image updated in the [discord developer portal](https://discord.com/developers/applications/)                                                       |
| Small image text | Text that appears when you put your mouse on top of the small image [example](https://imgur.com/HITRdSs)                                                              |
| Update delay     | How often the RPC should update (in milliseconds, default is 2000, less than that can lag your computer)                                                              |
| App ID           | The most important thing, that will identify your RPC from the others, you can get it at the [discord developer portal](https://discord.com/developers/applications/) |


If you want to make a sequence, you just have to enable sequence mode in the checkbox at the top. That enables a text field where you have to type the different messages you want (separated by **;**) in the RPC and the delay for the changing.

Example: hi;My name is Unzor; This is a test;
That will display three messages ('hi', 'My name is Unzor' and 'This is a test') and will change every 2000 milliseconds (default)


# How to contribute (Windows/Linux)

First, you will need to clone the repository, to do that open `cmd`/`terminal` and type `git clone https://github.com/UnzorZ/CustomRPC-WIP.git`. 
That will clone the repository in the folder you were at the moment. Keep in mind that you will need to have [git](https://git-scm.com/) installed in your pc.

Then open the folder with your preferred IDE, in my case, I use Intellij. Then make the changes you want and build it typing in the IDE terminal `./gradlew build`. Try it and if it works,
and you want your changes in the project, open a **Pull Request** and i will check it out.