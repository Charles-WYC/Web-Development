<?php

use yii\helpers\Html;


/* @var $this yii\web\View */
/* @var $model app\models\Bookstack */

$this->title = 'Create Bookstack';
$this->params['breadcrumbs'][] = ['label' => 'Bookstacks', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="bookstack-create">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
