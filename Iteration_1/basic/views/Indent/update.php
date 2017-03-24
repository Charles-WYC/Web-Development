<?php

use yii\helpers\Html;

/* @var $this yii\web\View */
/* @var $model app\models\Indent */

$this->title = 'Update Indent: ' . $model->indentID;
$this->params['breadcrumbs'][] = ['label' => 'Indents', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->indentID, 'url' => ['view', 'id' => $model->indentID]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="indent-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
