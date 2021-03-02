package controllers

import javax.inject._

import edu.trinity.videoquizreact.shared.SharedMessages
import play.api.mvc._

case class player(name:String, pos:String, g:Int)

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }
  def woah = Action {
    Ok(views.html.newFile("hello this is a string".split(" ")))
  }
  def doug = Action {
    val dougsStats:String = """Player           Pos  G M/Gm  FGm  FGa  PCT  3m  3a  PCT  FTm  FTA  PCT +/-/G  AVG
                          1 randle,julius     PF 35 36.7  290  601 .483  67  160 .419  172  213 .808   1.7 23.4
 2 barrett,rj        SG 35 33.3  219  505 .434  41  119 .345   97  133 .729   1.7 16.5
 3 rose,derrick      PG 10 24.8   47  109 .431  10   22 .455   21   24 .875   6.7 12.5
 4 payton,elfrid     PG 32 28.0  167  377 .443  14   58 .241   50   68 .735  -1.5 12.4
 5 quickley,immanu   SG 31 18.5  115  291 .395  53  138 .384   94  100 .940   1.2 12.2
 6 burks,alec        SG 23 25.0   87  208 .418  46  110 .418   45   54 .833   4.0 11.5
 7 bullock,reggie    SF 30 26.2   94  228 .412  52  137 .380   18   21 .857   0.3  8.6
 8 robinson,mitche    C 27 28.8  103  156 .660   0    0 .000   22   46 .478  -0.6  8.4
 9 rivers,austin     PG 21 21.0   58  135 .430  28   77 .364   10   14 .714  -2.1  7.3
10 knox,kevin        SF 25 15.1   45  114 .395  26   67 .388   10   12 .833  -2.7  5.0
11 noel,nerlens       C 30 21.0   61  103 .592   0    3 .000   20   31 .645   0.0  4.7
12 toppin,obi        PF 25 12.2   47   98 .480  12   41 .293   10   14 .714   0.1  4.6
13 ntilikina,frank   PG  7 12.7   10   26 .385   7   15 .467    3    5 .600   1.4  4.3
14 gibson,taj        PF 12 15.1   18   31 .581   2    7 .286    7   12 .583   2.8  3.8
15 smith,dennis      PG  3  9.3    2   10 .200   0    4 .000    5    6 .833  -2.0  3.0
16 harper,jared      PG  2  2.5    0    1 .000   0    0 .000    2    2 1.00  -1.5  1.0
17 brazdeikis,igna   SF  4  1.8    0    1 .000   0    0 .000    2    2 1.00  -1.5  0.5
18 pinson,theo       SG 10  2.4    1    7 .143   0    6 .000    0    0 .000  -1.7  0.2"""

    val header = dougsStats.split("\n")(0)
    val rest = dougsStats.split("\n").drop(1)
    val data = rest.map(y => y.split(" ").filter(x => x != ""))
    
    def toPlayer(line:Array[String]):player = {
      player(line(1),line(2), line(3).toInt)
    }
    val players:Array[player] = data.map(x => toPlayer(x))
    Ok(views.html.playerTable(players))
}




}
