Pour représenter un objet map<Integer, Rule> en JSON : 

    "rules": 
    [
      [
        <---Integer du map pour trier les Rules--->,
        {
          "facts":
          [
            <---Une liste d'objet Fact--->
          ],
          "answer":
          <---Un Objet Fact--->
        }
      ],
      [
         <---Un autre Integer du map pour trier les Rules--->,
        {
          "facts":
          [
            <---Une liste d'objet Fact--->
          ],
          "answer":
          <---Un Objet Fact--->
        } 
      ],

      ...
      
    ],