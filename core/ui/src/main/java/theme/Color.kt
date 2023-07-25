package theme

import androidx.compose.ui.graphics.Color

val orangeMain = Color(color = 0xFFf5783f)
val orangeSubLight = Color(color = 0xFFFDE4D8)
val orangeSubDark = Color(color = 0xFF683A00)

val blueMain = Color(color = 0xFF00A8D6)
val blueSubLight = Color(color = 0xFFC6E2FF)
val blueSubDark = Color(color = 0xFF002E68)

val greenMain = Color(color = 0xFF00b14f)
val greenSubLight = Color(color = 0xFFdbf4e6)
val greenSubDark = Color(color = 0xFF095023)

val primaryMain = greenMain
val primarySubLight = greenSubLight
val primarySubDark = greenSubDark

val colorCrimson = Color(color = 0xFFD31027)

val colorShark = Color(color = 0xFF25272a)
val colorMineShaft = Color(color = 0xFF2A2A2A)
val colorShuttleGray = Color(color = 0xFF666769)
val colorDustyGray = Color(color = 0xFF959595)
val colorMako = Color(color = 0xFF3D4145)
val colorGeyser = Color(color = 0xFFD9E0E3)
val colorPorcelain = Color(color = 0xFFf0f4f5)
val colorDarkElectricBlue = Color(color = 0xFF546E7A)

val colorDemo = Color(color = 0xFF1ba8d6)
val colorMako80 = Color(color = 0xFF3D4145).copy(alpha = 0.8f)

val colorTransparent50 = Color(color = 0x50000000)

val colorSecretPrimary = Color(color = 0xFF000000)
val colorSecretSecondary = colorDustyGray

val bgColors = arrayOf(
    Color(color = 0xFFed6494),
    Color(color = 0xFF65d5d1),
    Color(color = 0xFF1ba8d6),
    Color(color = 0xFFefae62),
    Color(color = 0xFF5bbc43),
    Color(color = 0xFFef5b54),
    Color(color = 0xFFb27cd3),
    Color(color = 0xFFfa944a),
)

val colorDarkGrey = Color(color = 0xFF202425)
val colorNeutral = Color(color = 0xFF808485)
val colorWhite = Color(color = 0xFFFFFFFF)
val colorWhite50 = Color(color = 0x50FFFFFF).copy(alpha = 0.5f)
val colorBlack = Color(color = 0xFF000000)
val colorImportant = Color(color = 0xFFd31027)
val colorNeutralLight = Color(color = 0xFFb0b4b5)
val colorDark = Color(color = 0xFF404445)
val colorLight = Color(color = 0xFFe0e4e5)
val colorLighter = Color(color = 0xFFf0f4f5)
val colorNeutralDarker = Color(color = 0xFF606465)

fun getColor(color: Int) =
    if (color >= 0 && color < bgColors.size) {
        bgColors[color]
    } else {
        bgColors[0]
    }
