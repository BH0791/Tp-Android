# Les permissions sous Android

Utilisation des fragments
- La méthode *testPermEvoie()* teste la capacité d'envoyer des SMS à l'exécution. 

  &nbsp;&nbsp;&nbsp; Ne demande aucune permission particulière dans le *AndroidManifest*.
- La méthode *testPermAccorder()* teste si la permission est déjà accordée est la

  &nbsp;&nbsp;&nbsp;demande effective de permission doit être faite en invoquant la méthode
  
  &nbsp;&nbsp;&nbsp;*requestPermissions()*
- La méthode *ensurePermission()* simule la demande au demarrage de app si oui

  &nbsp;&nbsp;&nbsp;permissions accordées si non une boite de dialogue demande Voulez-vous 

  &nbsp;&nbsp;&nbsp;réévaluer votre décision

```
AndroidManifest.xml

    <uses-feature
            android:name = "android.hardware.telephony"
            android:required = "false"
            />
    <uses-permission android:name = "android.permission.SEND_SMS"/>

```
