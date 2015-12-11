/**
 * Created by DrScott on 12/10/15.
 */
public class Main {
    public static void main(String[] args) {
//THIS ISN"T JAVA
        //THIS IS JUST MY JAVASCRIPT FOR PHASER PROJECT, WANTED TO COMMIT IT SO IT WAS LOGGED
        /*

        <!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
    <title>Phaser - Making your first game, part 9</title>
	<script type="text/javascript" src="js/phaser-ninja-physics.js"></script>
    <style type="text/css">
        body {
            margin: 0;
        }
    </style>
</head>//comment to commit
<body>

<script type="text/javascript">

var game = new Phaser.Game(640, 300, Phaser.AUTO, '', { preload: preload, create: create, update: update, render: render });
var vGravity = 300;
function preload() {

    game.load.tilemap('level1', 'assets/mapTest.json', null, Phaser.Tilemap.TILED_JSON);//pulls json file of the level
	  game.load.image('tiles', 'assets/patformkenney-32-4x39.png'); //pulls tileset art
		game.load.image('foregroundLayer', 'assets/platform_kenney/PineTree.png')
    game.load.image('sky', 'assets/sky.png');
    game.load.image('ground', 'assets/platform.png');
    game.load.image('star', 'assets/star.png');
    game.load.spritesheet('dude', 'assets/dude.png', 32, 48);


}

var player;
var platforms;
var cursors;

var stars;
var score = 0;
var scoreText;
var map;
var layer;
var foreground;
var collision;
var layerThree;
var tiles;
var background;


function create() {
  game.physics.startSystem(Phaser.Physics.NINJA);


		//game.world.setBounds(0,0,800,800);

    game.add.sprite(0, 0, 'sky');


    game.stage.backgroundColor = '#B8860B';
    map = game.add.tilemap('level1');


    map.addTilesetImage('layer1', 'tiles');
		map.addTilesetImage('foreground', 'foregroundLayer')
		//layerTwo = map.createLayer('secondary');
		//layerTwo.resizeWorld();
		layer = map.createLayer('primary');
		layer.resizeWorld();
	//	background = map.create('tertiary');
	//	background.resizeWorld();


		var slopeMap = [0,1,1,32,1,
1,33,32,30,
1,33,32,1,
1,33,1,2,
1,1,1,1,
1,1,1,3,
1,1,1,32,
1,1,1,32,
1,1,1,32,
1,1,1,32,
1,1,1,5,
1,1,1,13,
1,32,1,20,
12,2,30,1,
1,1,1,1,
1,3,2,1,
1,32,3,30,
1,32,1,1,
1,32,1,1,
1,32,1,1,
1,21,1,1,
1,13,30,1,
1,20,20,1,
30,12,32,1,
1,1,20,12,
1,33,30,1,
2,1,2,1,
1,1,1,1,
3,1,3,1,
32,20,32,1,
32,1,32,21,
32,20,32,32,
32,1,32,1,
5,1,5,2,
13,3,13,1,
4,42,4,32,
12,4,12,0,
1,13,1,0,
1,1,1,0

];
    tiles = game.physics.ninja.convertTilemap(map, layer, slopeMap);
		layerThree = map.createLayer('tertiary');
		layerThree.resizeWorld();



    player = game.add.sprite(32, game.world.height - 1250, 'dude');
		player.scale.setTo(0.7,0.8);
    game.physics.ninja.enable(player);
		player.scale.setTo(1,1);
  	player.body.bounce.y = 0.1;
		game.physics.ninja.gravity = 0.3;

    player.animations.add('left', [0, 1, 2, 3], 10, true);
    player.animations.add('right', [5, 6, 7, 8], 10, true);

    //  The score
    //scoreText = game.add.text(16, 16, 'score: 0', { fontSize: '32px', fill: '#000' });
		game.camera.follow(player);

		foreground = map.createLayer('secondary');
		foreground.resizeWorld();



		player.body.collideWorldBounds = true;


    //  Our controls.
   cursors = game.input.keyboard.createCursorKeys();

}

function update() {

	for (var i = 0; i < tiles.length; i++)
	{
	player.body.aabb.collideAABBVsTile(tiles[i].tile);
	}

      //game.physics.ninja.collide(player, layer);
    //  Checks to see if the player overlaps with any of the stars, if he does call the collectStar function
  //  game.physics.arcade.overlap(player, stars, collectStar, null, this);

    //  Reset the players velocity (movement)
  //  player.body.velocity.x = 0;


    if (cursors.left.isDown || game.input.keyboard.isDown(Phaser.Keyboard.A))
    {
        //  Move to the left
      //  player.body.velocity.x = -150;
			player.body.moveLeft(32);

        player.animations.play('left');
    }
    else if (cursors.right.isDown|| game.input.keyboard.isDown(Phaser.Keyboard.D))
    {
        //  Move to the right
      //  player.body.velocity.x = 150;
			player.body.moveRight(32);

        player.animations.play('right');
    }
    else
    {
        //  Stand still
        player.animations.stop();

        player.frame = 13;
    }

    //  Allow the player to jump if they are touching the ground.
    if (cursors.up.isDown && player.body.touching.down || game.input.keyboard.isDown(Phaser.Keyboard.W))
    {

			player.body.moveUp(320);
      //  player.body.velocity.y = -125;
    }





}

/*function collectStar (player, star) {

    // Removes the star from the screen
    star.kill();

    //  Add and update the score
    score += 10;
    scoreText.text = 'Score: ' + score;

}*//*
        function render() {

            game.debug.cameraInfo(game.camera, 32, 32);
            game.debug.spriteCoords(player, 32, 500);
        }






        </script>

        </body>
        </html>

        */



    }
}
