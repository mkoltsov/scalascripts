import scala.sys.process._
import java.net.URL
import java.io.File


"pwd" !

val wd =  "df -h" !!

Process("ls").lineStream
//println(result)

new URL("http://json4s.org/") #> "grep JSON" #>> new File("About_JSON.txt") !

"find src -name *.scala -exec grep null {} ;"  #|  "xargs test -z"  #&&  "echo null-free"  #||  "echo null detected"  !