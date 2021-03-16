package models

object userModel {

    
    val names: Array[Array[String]] = """Paul Abila,https://www.cs.trinity.edu/~pabila/,9050,9059,Pandora01
Joseph Baker,https://www.cs.trinity.edu/~jbaker6/,9060,9069,Pandora01
Matthew Barton,https://www.cs.trinity.edu/~mbarton/,9320,9329,Pandora05
Morgan Cartwright,https://www.cs.trinity.edu/~mcartwri/,9070,9079,Pandora01
Dane Claessen,https://www.cs.trinity.edu/~dclaesse/,9080,9089,Pandora01
Kevin Crusius,https://www.cs.trinity.edu/~kcrusius/,9090,9099,Pandora01
Chet Fagerstrom,https://www.cs.trinity.edu/~cfagerst/,9100,9109,Pandora01
Aaron Feleke,https://www.cs.trinity.edu/~afeleke/,9110,9119,Pandora02
Ryan Fernandez,https://www.cs.trinity.edu/~rfernan3/,9120,9129,Pandora02
Hans Fulton,https://www.cs.trinity.edu/~hfulton/,9130,9139,Pandora02
Turner Hall,https://www.cs.trinity.edu/~thall/,9140,9149,Pandora02
Morgen Halle,https://www.cs.trinity.edu/~mrosen0/,9150,9159,Pandora02
Kurt Hardee,https://www.cs.trinity.edu/~khardee/,9160,9169,Pandora03
Raini Huynh,https://www.cs.trinity.edu/~rhuynh1/,9170,9179,Pandora03
Jazmine Kibet,https://www.cs.trinity.edu/~jkibet/,9180,9189,Pandora03
Thomas Lauerman,https://www.cs.trinity.edu/~tlauerma/,9190,9199,Pandora03
Benjamin Malik,https://www.cs.trinity.edu/~bmalik/,9200,9209,Pandora03
Emma Miller,https://www.cs.trinity.edu/~emiller6/,9210,9219,Pandora04
Vasti Sarai Rios Rios,https://www.cs.trinity.edu/~vriosrio/,9220,9229,Pandora04
James Rosser,https://www.cs.trinity.edu/~jrosser/,9230,9239,Pandora04
Lizzie Ruetschle,https://www.cs.trinity.edu/~eruetsch/,9240,9249,Pandora04
Emerson Spradling,https://www.cs.trinity.edu/~espradli/,9250,9259,Pandora05
Christian Tatu,https://www.cs.trinity.edu/~ctatu/,9260,9269,Pandora05
Arjun Thakar,https://www.cs.trinity.edu/~athakar/,9270,9279,Pandora05
Alex Walker,https://www.cs.trinity.edu/~awalker3/,9280,9289,Pandora05
Connor Weisenberger,https://www.cs.trinity.edu/~cweisenb/,9290,9299,Pandora05
Sabrina Whitney,https://www.cs.trinity.edu/~swhitney/,9300,9309,Pandora06
Caden Young,https://www.cs.trinity.edu/~cyoung5/,9310,9319,Pandora06""".split("\n").map(x => x.split(","))
    def makeUsername(name:String): String = {
        names.filter(x => x(0) == name).map(x => {
            val url = x(1)
            val tilde = url.indexOf("~")
            val username = url.substring(tilde+1).dropRight(1)
        })
    }
    
    val friends = """Paul Abila,bmalik,mbarton,dclaesse,hfulton,khardee,emiller6,cweisenb
Joseph Baker,mbarton,mcartwri,afeleke,thall,jkibet,emiller6,ctatu
Matthew Barton,pabila,kcrusius,rfernan3,khardee,tlauerma,athakar,cweisenb
Morgan Cartwright,jbaker6,kcrusius,afeleke,jkibet,eruetsch,cyoung5
Dane Claessen,pabila,mcartwri,cfagerst,khardee,tlauerma,ctatu,cweisenb
Kevin Crusius,bmalik,jbaker6,dclaesse,thall,rhuynh1,eruetsch,swhitney
Chet Fagerstrom,mcartwri,kcrusius,afeleke,khardee,vriosrio,awalker3
Aaron Feleke,pabila,mcartwri,rfernan3,mrosen0,emiller6,espradli,cyoung5
Ryan Fernandez,jbaker6,cfagerst,hfulton,thall,tlauerma,eruetsch
Hans Fulton,pabila,mbarton,cfagerst,mrosen0,rhuynh1,jrosser,cweisenb
Turner Hall,mcartwri,kcrusius,afeleke,mrosen0,emiller6,ctatu,swhitney
Morgen Halle,bmalik,jbaker6,kcrusius,hfulton,tlauerma,athakar,cyoung5
Kurt Hardee,pabila,mcartwri,rfernan3,thall,jkibet,jrosser,awalker3
Raini Huynh,jbaker6,mbarton,dclaesse,thall,jkibet,eruetsch,awalker3
Jazmine Kibet,mcartwri,kcrusius,rfernan3,mrosen0,vriosrio,ctatu,cweisenb
Thomas Lauerman,pabila,mbarton,afeleke,mrosen0,emiller6,espradli,cyoung5
Benjamin Malik,dclaesse,cfagerst,rfernan3,rhuynh1,vriosrio,awalker3
Emma Miller,bmalik,pabila,cfagerst,afeleke,jkibet,jrosser,athakar,swhitney
Vasti Sarai Rios Rios,mbarton,mcartwri,hfulton,vriosrio,espradli,cweisenb
James Rosser,jbaker6,mcartwri,kcrusius,thall,rhuynh1,eruetsch,awalker3
Lizzie Ruetschle,pabila,jbaker6,afeleke,mrosen0,khardee,jrosser,awalker3,cweisenb
Emerson Spradling,mbarton,kcrusius,hfulton,thall,rhuynh1,espradli
Christian Tatu,dclaesse,cfagerst,afeleke,mrosen0,rhuynh1,eruetsch,swhitney
Arjun Thakar,bmalik,mcartwri,kcrusius,hfulton,khardee,vriosrio,athakar
Alex Walker,pabila,mcartwri,cfagerst,afeleke,mrosen0,tlauerma,ctatu,cyoung5
Connor Weisenberger,jbaker6,mbarton,dclaesse,thall,khardee,espradli,swhitney
Sabrina Whitney,jbaker6,dclaesse,kcrusius,afeleke,rhuynh1,eruetsch,cyoung5
Caden Young,pabila,mbarton,dclaesse,cfagerst,thall,khardee,vriosrio,awalker3""".split("\n").map(line => line.split(","))
    val usernames: Array[(String, Array[String])] = friends.map(x => (x.head, x.tail))
    
    def getFriendsByName(name:String):Array[String] = {
        usernames(usernames.indexWhere(x => x._1 == name))
    }
}
