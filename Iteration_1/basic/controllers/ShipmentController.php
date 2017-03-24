<?php

namespace app\controllers;

use Yii;
use app\models\Shipment;
use app\models\ShipmentSearch;
use yii\web\Controller;
use yii\web\NotFoundHttpException;
use yii\filters\VerbFilter;

/**
 * ShipmentController implements the CRUD actions for Shipment model.
 */
class ShipmentController extends Controller
{
    /**
     * @inheritdoc
     */
    public function behaviors()
    {
        return [
            'verbs' => [
                'class' => VerbFilter::className(),
                'actions' => [
                    'delete' => ['POST'],
                ],
            ],
        ];
    }

    /**
     * Lists all Shipment models.
     * @return mixed
     */
    public function actionIndex()
    {
        $searchModel = new ShipmentSearch();
        $dataProvider = $searchModel->search(Yii::$app->request->queryParams);

        return $this->render('index', [
            'searchModel' => $searchModel,
            'dataProvider' => $dataProvider,
        ]);
    }

    /**
     * Displays a single Shipment model.
     * @param string $bookID
     * @param string $indentID
     * @return mixed
     */
    public function actionView($bookID, $indentID)
    {
        return $this->render('view', [
            'model' => $this->findModel($bookID, $indentID),
        ]);
    }

    /**
     * Creates a new Shipment model.
     * If creation is successful, the browser will be redirected to the 'view' page.
     * @return mixed
     */
    public function actionCreate()
    {
        $model = new Shipment();

        if ($model->load(Yii::$app->request->post()) && $model->save()) {
            return $this->redirect(['view', 'bookID' => $model->bookID, 'indentID' => $model->indentID]);
        } else {
            return $this->render('create', [
                'model' => $model,
            ]);
        }
    }

    /**
     * Updates an existing Shipment model.
     * If update is successful, the browser will be redirected to the 'view' page.
     * @param string $bookID
     * @param string $indentID
     * @return mixed
     */
    public function actionUpdate($bookID, $indentID)
    {
        $model = $this->findModel($bookID, $indentID);

        if ($model->load(Yii::$app->request->post()) && $model->save()) {
            return $this->redirect(['view', 'bookID' => $model->bookID, 'indentID' => $model->indentID]);
        } else {
            return $this->render('update', [
                'model' => $model,
            ]);
        }
    }

    /**
     * Deletes an existing Shipment model.
     * If deletion is successful, the browser will be redirected to the 'index' page.
     * @param string $bookID
     * @param string $indentID
     * @return mixed
     */
    public function actionDelete($bookID, $indentID)
    {
        $this->findModel($bookID, $indentID)->delete();

        return $this->redirect(['index']);
    }

    /**
     * Finds the Shipment model based on its primary key value.
     * If the model is not found, a 404 HTTP exception will be thrown.
     * @param string $bookID
     * @param string $indentID
     * @return Shipment the loaded model
     * @throws NotFoundHttpException if the model cannot be found
     */
    protected function findModel($bookID, $indentID)
    {
        if (($model = Shipment::findOne(['bookID' => $bookID, 'indentID' => $indentID])) !== null) {
            return $model;
        } else {
            throw new NotFoundHttpException('The requested page does not exist.');
        }
    }
}
